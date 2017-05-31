package com.audit.app.auditform.controller;

import com.audit.app.auditform.model.Response.AuditQuestions;
import com.audit.app.auditform.model.Response.Project;
import com.audit.app.auditform.model.Response.StatusCodes;
import com.audit.app.auditform.service.AuditFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping ("audit-app/admin/auditform")
public class AuditFormController
{
    private AuditFormService auditFormService;

    @Autowired
    public AuditFormController (final AuditFormService auditFormService)
    {
        this.auditFormService = auditFormService;
    }


    @GetMapping ("/complianceStatusCodes")
    public ResponseEntity<List<StatusCodes>> getComplianceStatusCode () throws SQLException
    {
        return new ResponseEntity<>(auditFormService.getComplianceStatusCode(), HttpStatus.OK);
    }

    @GetMapping ("/projectList")
    public ResponseEntity<List<Project>> getAllProjects () throws SQLException
    {
        return new ResponseEntity<>(this.auditFormService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping ("/allQuestions/{projectId}")
    public ResponseEntity<List<AuditQuestions>> getAllQuestions (@PathVariable ("projectId") int projectId) throws SQLException
    {

        return new ResponseEntity<List<AuditQuestions>>(this.auditFormService.getAllQuestions(projectId), HttpStatus.OK);
    }

    @PostMapping ("/submit")
    public ResponseEntity<Integer> submitForm (@RequestBody List<AuditQuestions> auditQuestions) throws SQLException
    {
        int rowsUpdated = this.auditFormService.submitForm(auditQuestions);
        return new ResponseEntity<>(rowsUpdated, HttpStatus.OK);
    }

}
