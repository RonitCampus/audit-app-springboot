package com.audit.app.Admin_Services._Data_Forms.ProjectMaster.service;

import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model.ProjectType;
import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.repository.ProjectMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class ProjectMasterService
{
    private final ProjectMasterRepository projectMasterRepository;

    @Autowired
    public ProjectMasterService (final ProjectMasterRepository projectMasterRepository)
    {
        this.projectMasterRepository = projectMasterRepository;
    }

    public List<ProjectType> getAllProjectTypes () throws SQLException
    {
        return this.projectMasterRepository.getAllProjectTypes();
    }
}
