package com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.controller;

import com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.model.Nc;
import com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.service.AllNcsForProjectService;
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
@RequestMapping ("/Admin_Services/Data_forms/AllNcsForProject")
public class AllNcsForProjectController
{

    private AllNcsForProjectService allNcsForProjectService;

    @Autowired
    public AllNcsForProjectController (final AllNcsForProjectService allNcsForProjectService)
    {
        this.allNcsForProjectService = allNcsForProjectService;
    }

    @GetMapping ("/{projectId}")
    public ResponseEntity<List<Nc>> getAllNcsForProject (@PathVariable ("projectId") final int projectId) throws SQLException
    {
        return new ResponseEntity<>(this.allNcsForProjectService.getAllNcsForProject(projectId), HttpStatus.OK);
    }
}
