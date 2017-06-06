package com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.repository;

import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model.AuditTimeTableForm;
import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model.ProjInfo;
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
public class CreateAuditTimeTableRepository
{

    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public CreateAuditTimeTableRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }


    public List<ProjInfo> getProjects () throws SQLException
    {
        String sql = "select Project_Code, Project_Name, Project_Mgr from ProjectMaster";
        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        ProjInfo projInfo = null;
        List<ProjInfo> projInfoList = new ArrayList<>();

        while (resultSet.next())
        {
            projInfo = this.applicationContext.getBean(ProjInfo.class);
            projInfo.setProjectCode(resultSet.getInt("Project_Code"));
            projInfo.setProjectName(resultSet.getString("Project_Name"));
            projInfo.setProjectManager(resultSet.getString("Project_Mgr"));
            projInfoList.add(projInfo);
        }

        return projInfoList;
    }

    public boolean addProjecttoTimeTable (AuditTimeTableForm auditTimeTableForm) throws SQLException
    {
        String sql = "insert into AuditTimeTable ([Project_Code],[Scheduled_On],[Auditor],[Auditee],[Remark],[Audit_Complete_Status]) values (?,?,?,?,?,?)";


        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, auditTimeTableForm.getProjectCode());
        preparedStatement.setDate(2, auditTimeTableForm.getScheduledOn());
        preparedStatement.setString(3, auditTimeTableForm.getAuditor());
        preparedStatement.setString(4, auditTimeTableForm.getAuditee());
        preparedStatement.setString(5, auditTimeTableForm.getRemark());
        preparedStatement.setBoolean(6, auditTimeTableForm.isStatus());

        return preparedStatement.executeUpdate() > 0;
    }
}
