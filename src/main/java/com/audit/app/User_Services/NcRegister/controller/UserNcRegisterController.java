package com.audit.app.User_Services.NcRegister.controller;

import com.audit.app.User_Services.NcRegister.model.UserNcRegisterAuditInfo;
import com.audit.app.User_Services.NcRegister.model.UserNcUpdate;
import com.audit.app.User_Services.NcRegister.service.UserNcRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping ("/UserServices/NcRegister")
public class UserNcRegisterController
{

    private final UserNcRegisterService userNcRegisterService;

    @Autowired
    public UserNcRegisterController (final UserNcRegisterService userNcRegisterService)
    {
        this.userNcRegisterService = userNcRegisterService;
    }

    @GetMapping ("/AuditInfo/{projectId}")
    public UserNcRegisterAuditInfo getAuditInfo (@PathVariable ("projectId") int projectId) throws SQLException
    {
        return this.userNcRegisterService.getAuditInfo(projectId);
    }

    @PostMapping ("/Update")
    public boolean updateNcRegister (@RequestBody final UserNcUpdate userNcUpdate) throws SQLException
    {
        return this.userNcRegisterService.updateNcRegister(userNcUpdate);
    }
}
