package com.audit.app.Admin_Services._Data_Forms.ProjectMaster.repository;

import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model.ProjectMasterForm;
import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model.ProjectType;
import com.audit.app.Db.DbConfig;
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

    public boolean addNewProject (ProjectMasterForm projectMasterForm) throws SQLException
    {

        String sql = "insert into ProjectMaster values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, projectMasterForm.getProjectName());
        preparedStatement.setString(2, projectMasterForm.getProjectMgr());
        preparedStatement.setString(3, projectMasterForm.getDeliveryMgr());
        preparedStatement.setString(4, projectMasterForm.getRelationshipMgr());
        preparedStatement.setString(5, projectMasterForm.getClient());
        preparedStatement.setString(6, projectMasterForm.getPortfolio());
        preparedStatement.setDate(7, projectMasterForm.getStartDt());
        preparedStatement.setDate(8, projectMasterForm.getEndDt());
        preparedStatement.setInt(9, projectMasterForm.getProjectType());
        preparedStatement.setInt(10, projectMasterForm.getAssociateCount());
        preparedStatement.setBoolean(11, projectMasterForm.isProjectActiveStatus());
        preparedStatement.setString(12, null);

        int rowsUpdated = preparedStatement.executeUpdate();

        return rowsUpdated > 0;
    }
}
