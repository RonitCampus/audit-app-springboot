package com.audit.app.ncRegister.repository;

import com.audit.app.Db.DbConfig;
import com.audit.app.ncRegister.model.resposne.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        String sql = String.format("select * from ProjectMaster as pm , AuditDB.dbo.AuditTimeTable as att where pm.Project_Code = %s", projectId);
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

}
