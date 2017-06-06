package com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.controller;

import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model.AuditTimeTableForm;
import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model.ProjInfo;
import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.service.CreateAuditTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping ("/Admin_Services/Data_forms/CreateAuditTimeTable")
public class CreateAuditTimeTableController
{

    private final CreateAuditTimeTableService createAuditTimeTableService;

    @Autowired
    public CreateAuditTimeTableController (final CreateAuditTimeTableService createAuditTimeTableService)
    {
        this.createAuditTimeTableService = createAuditTimeTableService;
    }

    @GetMapping ("/getProjects")
    public List<ProjInfo> getProjects () throws SQLException
    {
        return this.createAuditTimeTableService.getProjects();
    }

    @PostMapping ("/addProject")
    public boolean addProjecttoTimeTable (@RequestBody AuditTimeTableForm auditTimeTableForm) throws SQLException
    {
        return this.createAuditTimeTableService.addProjecttoTimeTable(auditTimeTableForm);
    }
}
