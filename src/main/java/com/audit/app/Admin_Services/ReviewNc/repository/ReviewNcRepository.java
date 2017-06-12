package com.audit.app.Admin_Services.ReviewNc.repository;

import com.audit.app.Admin_Services.ReviewNc.model.NcInfo;
import com.audit.app.Admin_Services.ReviewNc.model.NcInfoUpdateForm;
import com.audit.app.Db.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by matth on 6/8/2017.
 */
@Repository
public class ReviewNcRepository {

    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public ReviewNcRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }


    public NcInfo getNcInfo(int ncId) throws SQLException {
        String sql = String.format("  select * from NcRegister where Nc_Id = %s",ncId);

        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        NcInfo ncInfo = this.applicationContext.getBean(NcInfo.class);

        if (resultSet.next()){
            ncInfo.setNcId(resultSet.getInt("Nc_Id"));
            ncInfo.setRaisedBy(resultSet.getString("Nc_RaisedBy"));
            ncInfo.setDescription(resultSet.getString("Nc_Description"));
            ncInfo.setAssignedTo(resultSet.getString("Nc_AssignedTo"));
            ncInfo.setRaisedBy(resultSet.getString("Nc_RaisedBy"));
            ncInfo.setResolution(resultSet.getString("Nc_ResolutionFromAuditee"));
            ncInfo.setProjectName(resultSet.getString("Project_Name"));
            ncInfo.setStatus(resultSet.getInt("Nc_Status"));
            ncInfo.setNcDate(resultSet.getDate("Nc_Date"));
            ncInfo.setExpectedCloseDate(resultSet.getDate("Expected_CloseDt"));
        }

        return ncInfo;

    }

    public Boolean updateNc(NcInfoUpdateForm ncInfoUpdateForm) throws SQLException {

        System.out.println(ncInfoUpdateForm);

        String sql = "update NcRegister set Nc_ClosedBy= ?, Nc_ClosedDt= ? , Nc_ClosureRemark= ?, Nc_Status = ? where Nc_Id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1,ncInfoUpdateForm.getClosedBy());
        preparedStatement.setDate(2,ncInfoUpdateForm.getCloseDate());
        preparedStatement.setString(3,ncInfoUpdateForm.getCloseRemark());
        preparedStatement.setInt(4,303);//303 => Closed state
        preparedStatement.setInt(5,ncInfoUpdateForm.getNcId());

        return preparedStatement.executeUpdate() > 0;
    }
}
