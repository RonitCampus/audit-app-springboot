package com.audit.app.ncRegister.repository;

import com.audit.app.Db.DbConfig;
import com.audit.app.ncRegister.model.request.CreateNcForm;
import com.audit.app.ncRegister.model.resposne.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by Infocepts India in 2017.
 */
@Repository
public class NcRegisterRepository
{
    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public NcRegisterRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }


    public ProjectInfo getProjectInfo (int projectId) throws SQLException
    {

        String sql = String.format("  select * from ProjectMaster as pm , AuditDB.dbo.AuditTimeTable as att where pm.Project_Code = %s and att.Project_Code = %s;" , projectId, projectId);
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        ProjectInfo projectInfo = applicationContext.getBean(ProjectInfo.class);
        if (resultSet.next())
        {
            projectInfo.setId(resultSet.getInt("Project_Code"));
            projectInfo.setAuditId(resultSet.getInt("Audit_Id"));
            projectInfo.setName(resultSet.getString("Project_Name"));
            projectInfo.setAuditor(resultSet.getString("Auditor"));
            projectInfo.setScheduledOn(resultSet.getDate("Scheduled_on"));
            projectInfo.setAuditee(resultSet.getString("Auditee"));
            projectInfo.setRemark(resultSet.getString("remark"));
            projectInfo.setStatus(resultSet.getBoolean("Compliance_Status"));
        }

        return projectInfo;
    }


    public boolean createNc (final CreateNcForm createNcForm) throws SQLException
    {
        String sql = "insert into NcRegister (Audit_Id, Project_Name ,Nc_RaisedBy,Nc_AssignedTo,Nc_Date,Nc_Description,Nc_Status, Expected_CloseDt) values (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, createNcForm.getAuditId());
        preparedStatement.setString(2, createNcForm.getProjectName());
        preparedStatement.setString(3, createNcForm.getRaisedBy());
        preparedStatement.setString(4, createNcForm.getAssignedTo());
        preparedStatement.setDate(5, createNcForm.getNcDate());
        preparedStatement.setString(6, createNcForm.getDescription());
        preparedStatement.setInt(7, 301);//301 -> assigned to Auditee
        preparedStatement.setDate(8, createNcForm.getExpectedCloseDate());
        return preparedStatement.executeUpdate() > 0;
    }
}
