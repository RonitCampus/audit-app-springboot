package com.audit.app.ncRegister.controller;

import com.audit.app.ncRegister.model.request.CreateNcForm;
import com.audit.app.ncRegister.model.resposne.ProjectInfo;
import com.audit.app.ncRegister.service.NcRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping ("audit-app/admin/ncform")
public class NcRegisterController
{
    NcRegisterService ncRegisterService;

    @Autowired
    public NcRegisterController (final NcRegisterService ncRegisterService)
    {
        this.ncRegisterService = ncRegisterService;
    }

    @GetMapping ("/getProjectInfo/{projectId}")
    public ProjectInfo getProjectInfo (@PathVariable ("projectId") int projectId) throws SQLException
    {
        return this.ncRegisterService.getProjectInfo(projectId);
    }

    @PostMapping ("/createNcForm")
    public boolean createNc (@RequestBody final CreateNcForm createNcForm) throws SQLException
    {
        return this.ncRegisterService.createNc(createNcForm);
    }

}
