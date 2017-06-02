package com.audit.app.User_Services.NcRegister.repository;

import com.audit.app.Db.DbConfig;
import com.audit.app.User_Services.NcRegister.model.UserNcRegisterAuditInfo;
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
public class UserNcRegisterRepository
{

    private final ApplicationContext applicationContext;
    private final Connection connection;

    @Autowired
    public UserNcRegisterRepository (final ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }


    public UserNcRegisterAuditInfo getAuditInfo (int projectId) throws SQLException
    {
        String sql = String.format("select * from ProjectMaster as pm , AuditDB.dbo.AuditTimeTable as att where pm.Project_Code = %s", projectId);

        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        UserNcRegisterAuditInfo userNcRegisterAuditInfo = this.applicationContext.getBean(UserNcRegisterAuditInfo.class);

        if (resultSet.next())
        {
            userNcRegisterAuditInfo.setAuditId(resultSet.getInt("Audit_Id"));
            userNcRegisterAuditInfo.setName(resultSet.getString("Project_Name"));
            userNcRegisterAuditInfo.setAuditee(resultSet.getString("Auditee"));
            userNcRegisterAuditInfo.setAuditor(resultSet.getString("Auditor"));
            userNcRegisterAuditInfo.setRemark(resultSet.getString("Remarks"));
            userNcRegisterAuditInfo.setStatus(resultSet.getBoolean("Status"));
            //ncRegisterAuditInfo.setExpectedCloseDt();
        }

        return userNcRegisterAuditInfo;

    }
}
