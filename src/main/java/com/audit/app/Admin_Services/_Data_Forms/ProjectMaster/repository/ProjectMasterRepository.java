package com.audit.app.Admin_Services._Data_Forms.ProjectMaster.repository;

import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model.ProjectType;
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
public class ProjectMasterRepository
{

    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public ProjectMasterRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }


    public List<ProjectType> getAllProjectTypes () throws SQLException
    {
        String sql = "select * from ProjectTypeMaster";
        Statement statement = this.connection.createStatement();

        List<ProjectType> projectTypeList = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery(sql);

        ProjectType projectType = null;

        while (resultSet.next())
        {
            projectType = this.applicationContext.getBean(ProjectType.class);

            projectType.setProjectType(resultSet.getInt("Project_Type"));
            projectType.setProjectTypeDescription(resultSet.getString("Project_Type_Description"));

            projectTypeList.add(projectType);
        }

        return projectTypeList;
    }
}
