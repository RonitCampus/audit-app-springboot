package com.audit.app.auditform.repository;

import com.audit.app.Db.DbConfig;
import com.audit.app.auditform.model.Response.AuditQuestions;
import com.audit.app.auditform.model.Response.Project;
import com.audit.app.auditform.model.Response.StatusCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "select Project_Code , Project_name from ProjectMaster";

        ResultSet resultSet = statement.executeQuery(sql);
        List<Project> projectList = new ArrayList<>();

        while (resultSet.next())
        {
            Project project = this.applicationContext.getBean(Project.class);
            project.setId(resultSet.getInt("Project_Code"));
            project.setName(resultSet.getString("Project_name"));
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
            auditQuestion.setComplianceStatus(resultSet.getString("status"));
            auditQuestion.setRemark(resultSet.getString("Remarks"));

            auditQuestionsList.add(auditQuestion);
        }

        return auditQuestionsList;
    }

}