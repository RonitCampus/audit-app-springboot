package com.audit.app.auditform.repository;

import com.audit.app.Db.DbConfig;
import com.audit.app.auditform.model.Response.AuditQuestions;
import com.audit.app.auditform.model.Response.Project;
import com.audit.app.auditform.model.Response.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Repository
public class AuditFromRepository
{

    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public AuditFromRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }

    public List<StatusCodes> getComplianceStatusCode () throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "select * from ComplianceStatusCode";

        ResultSet resultSet = statement.executeQuery(sql);

        List<StatusCodes> complianceStatusList = new ArrayList<>();

        while (resultSet.next())
        {

            StatusCodes statusCode = applicationContext.getBean(StatusCodes.class);

            statusCode.setId(resultSet.getInt("Compliance_Id"));
            statusCode.setStatus(resultSet.getString("Compliance_Status"));

            complianceStatusList.add(statusCode);
        }
        return complianceStatusList;
    }

    public List<Project> getAllProjects () throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = "select pm.Project_Code, pm.Project_Name, pm.Project_Mgr, att.Schedule_On, att.Conducted_On, att.Auditor, att.Auditee from ProjectMaster as pm , AuditDB.dbo.AuditTimeTable as att where pm.Project_Code = att.Project_Code";

        ResultSet resultSet = statement.executeQuery(sql);
        List<Project> projectList = new ArrayList<>();

        while (resultSet.next())
        {
            Project project = this.applicationContext.getBean(Project.class);
            project.setId(resultSet.getInt("Project_Code"));
            project.setName(resultSet.getString("Project_name"));
            project.setProjectMgr(resultSet.getString("Project_Mgr"));
            project.setAuditor(resultSet.getString("Auditor"));
            project.setAuditee(resultSet.getString("Auditee"));
            project.setScheduledOn(resultSet.getDate("Schedule_On"));
            project.setConductedOn(resultSet.getDate("Conducted_On"));

            projectList.add(project);
        }
        return projectList;
    }

    public List<AuditQuestions> getAllQuestions (int projectId) throws SQLException
    {
        Statement statement = this.connection.createStatement();
        String sql = String.format("select * from QuestionBank as qb, QuestionProject as qp, ProjectMaster pm, AuditTimeTable as att where qb.Question_Id = qp.Question_Id and pm.Project_Code = %s and pm.Project_Type = qp.Project_Type; ", projectId);

        ResultSet resultSet = statement.executeQuery(sql);
        List<AuditQuestions> auditQuestionsList = new ArrayList<>();
        while (resultSet.next())
        {
            AuditQuestions auditQuestion = this.applicationContext.getBean(AuditQuestions.class);
            auditQuestion.setAuditd(resultSet.getInt("Audit_Id"));
            auditQuestion.setQuetionId(resultSet.getInt("Question_Id"));
            auditQuestion.setQuestion(resultSet.getString("Question_Description"));
            auditQuestion.setComplianceStatus(resultSet.getInt("Compliance_Id"));
            //auditQuestion.setRemark(resultSet.getString("Remarks"));
            auditQuestion.setProjectId(resultSet.getInt("Project_Code"));
            auditQuestion.setWeightage(resultSet.getInt("Weightage"));

            auditQuestionsList.add(auditQuestion);
        }

        return auditQuestionsList;
    }

    public int submitForm (List<AuditQuestions> auditQuestions) throws SQLException
    {

        PreparedStatement preparedStatement;

        int rowsUpdated = 0;
        int nonCompliantScore = 0;
        int compliantScore = 0;


        for (AuditQuestions auditQuestion : auditQuestions)
        {
            if (auditQuestion.getComplianceStatus() == 201)
            {
                compliantScore += auditQuestion.getWeightage();
            }
            else if (auditQuestion.getComplianceStatus() == 202)
            {
                nonCompliantScore += auditQuestion.getWeightage();
            }

            String sql = "insert into ProjectAudit values (?,?,?,?,?)";
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, auditQuestion.getAuditd());
            preparedStatement.setInt(2, auditQuestion.getProjectId());
            preparedStatement.setInt(3, auditQuestion.getQuetionId());
            preparedStatement.setInt(4, auditQuestion.getComplianceStatus());
            preparedStatement.setString(5, auditQuestion.getQuestion());
            //add date time stamp here

            rowsUpdated += preparedStatement.executeUpdate();
        }

        int total = nonCompliantScore + compliantScore;
        float percentage = ((compliantScore * 100) / (total == 0 ? 1 : total));

        int auditId = auditQuestions.stream().findFirst().get().getAuditd();

        String sql = String.format("update AuditTimeTable set Compliance_Score=%s where Audit_Id=%s", percentage, auditId);

        preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.executeUpdate();

        return rowsUpdated;
    }


}
