package com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.repository;

import com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.model.Nc;
import com.audit.app.Db.DbConfig;
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
public class AllNcForProjectRepository
{
    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public AllNcForProjectRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }


    public List<Nc> getAllNcsForProject (final int projectId) throws SQLException
    {
        String sql = String.format("select * from NcRegister as nc where nc.Project_Name = ( select project_name from ProjectMaster where Project_Code = %s )" , projectId);

        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        List<Nc> ncList = new ArrayList<>();
        Nc nc = null;
        while (resultSet.next())
        {
            nc = this.applicationContext.getBean(Nc.class);
            nc.setNcId(resultSet.getInt("Nc_Id"));
            nc.setAssignedTo(resultSet.getString("Nc_AssignedTo"));
            nc.setRaisedBy(resultSet.getString("Nc_RaisedBy"));
            nc.setExpectedCloseDate(resultSet.getDate("Expected_CloseDt"));
            nc.setNcDate(resultSet.getDate("Nc_Date"));
            nc.setStatus(resultSet.getInt("Nc_Status"));

            ncList.add(nc);
        }
        return ncList;
    }
}
