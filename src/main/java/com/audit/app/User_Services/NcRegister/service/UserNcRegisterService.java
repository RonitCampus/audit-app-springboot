package com.audit.app.User_Services.NcRegister.service;

import com.audit.app.User_Services.NcRegister.model.UserNcRegisterAuditInfo;
import com.audit.app.User_Services.NcRegister.repository.UserNcRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class UserNcRegisterService
{
    private final UserNcRegisterRepository userNcRegisterRepository;

    @Autowired
    public UserNcRegisterService (final UserNcRegisterRepository userNcRegisterRepository)
    {
        this.userNcRegisterRepository = userNcRegisterRepository;
    }


    public UserNcRegisterAuditInfo getAuditInfo (int projectId) throws SQLException
    {
        return this.userNcRegisterRepository.getAuditInfo(projectId);
    }
}
