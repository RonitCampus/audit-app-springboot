package com.audit.app.Admin_Services._Data_Forms.ProjectMaster.controller;

import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model.ProjectMasterForm;
import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model.ProjectType;
import com.audit.app.Admin_Services._Data_Forms.ProjectMaster.service.ProjectMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private final ProjectMasterService projectMasterService;

    @Autowired
    public ProjectMasterController (final ProjectMasterService projectMasterService)
    {
        this.projectMasterService = projectMasterService;
    }

    @GetMapping ("/ProjectTypes")
    public List<ProjectType> getAllProjectTypes () throws SQLException
    {
        return this.projectMasterService.getAllProjectTypes();
    }

    @PostMapping ("/addNewProject")
    public boolean addNewProject (@RequestBody ProjectMasterForm projectMasterForm) throws SQLException
    {
        return this.projectMasterService.addNewProject(projectMasterForm);
    }


}
