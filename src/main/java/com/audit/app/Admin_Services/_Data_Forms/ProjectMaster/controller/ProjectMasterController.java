package com.audit.app.Admin_Services._Data_Forms.ProjectMaster.controller;

import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model.ProjectType;
import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.service.ProjectMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping ("Admin_Services/Data_forms/ProjectMaster")
public class ProjectMasterController
{

    private final ProjectMasterService projectMasterRepository;

    @Autowired
    public ProjectMasterController (final ProjectMasterService projectMasterRepository)
    {
        this.projectMasterRepository = projectMasterRepository;
    }

    @GetMapping ("/ProjectTypes")
    public List<ProjectType> getAllProjectTypes () throws SQLException
    {
        return this.projectMasterRepository.getAllProjectTypes();
    }
}
