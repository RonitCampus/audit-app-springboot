package com.audit.app.User_Services.NcRegister.repository;

import com.audit.app.Db.DbConfig;
import com.audit.app.User_Services.NcRegister.model.UserNcRegisterAuditInfo;
import com.audit.app.User_Services.NcRegister.model.UserNcUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;

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


    public UserNcRegisterAuditInfo getAuditInfo (int ncId) throws SQLException
    {
        String sql = String.format("SELECT Nc_Id,Audit_Id,Nc_Description,Nc_RaisedBy,Nc_AssignedTo,Nc_Status,Project_Name,Expected_CloseDt FROM NcRegister where Nc_Id = %s" , ncId);

        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        UserNcRegisterAuditInfo userNcRegisterAuditInfo = this.applicationContext.getBean(UserNcRegisterAuditInfo.class);

        if (resultSet.next())
        {
            userNcRegisterAuditInfo.setNcId(resultSet.getInt("Nc_Id"));
            userNcRegisterAuditInfo.setAuditId(resultSet.getInt("Audit_Id"));
            userNcRegisterAuditInfo.setProjectName(resultSet.getString("Project_Name"));
            userNcRegisterAuditInfo.setRaisedBy(resultSet.getString("Nc_RaisedBy"));
            userNcRegisterAuditInfo.setAssignedTo(resultSet.getString("Nc_AssignedTo"));
            userNcRegisterAuditInfo.setNcDescription(resultSet.getString("Nc_Description"));
            userNcRegisterAuditInfo.setNcStatus(resultSet.getInt("Nc_Status"));
            userNcRegisterAuditInfo.setExpectedCloseDate(resultSet.getDate("Expected_CloseDt"));
        }

        return userNcRegisterAuditInfo;
    }

    public boolean updateNcRegister (final UserNcUpdate userNcUpdate) throws SQLException
    {
        String sql = "update NcRegister set Nc_ResolutionFromAuditee=? , Nc_Status = ? , Nc_ResolutionDt = ? where Nc_Id= ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1, userNcUpdate.getResolutionFromAuditee());
        preparedStatement.setString(2, "302"); //302=> Assigned to Auditor
        preparedStatement.setDate(3, userNcUpdate.getResolutionDate());
        preparedStatement.setInt(4, userNcUpdate.getNcId());

        return preparedStatement.executeUpdate() > 0;
    }
}
