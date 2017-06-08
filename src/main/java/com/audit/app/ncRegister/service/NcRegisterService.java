package com.audit.app.ncRegister.service;

import com.audit.app.ncRegister.model.request.CreateNcForm;
import com.audit.app.ncRegister.model.resposne.ProjectInfo;
import com.audit.app.ncRegister.repository.NcRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class NcRegisterService
{

    NcRegisterRepository ncRegisterRepository;

    @Autowired
    public NcRegisterService (final NcRegisterRepository ncRegisterRepository)
    {
        this.ncRegisterRepository = ncRegisterRepository;
    }

    public ProjectInfo getProjectInfo (int projectId) throws SQLException
    {
        return this.ncRegisterRepository.getProjectInfo(projectId);
    }

    public boolean createNc (final CreateNcForm createNcForm) throws SQLException
    {
        return this.ncRegisterRepository.createNc(createNcForm);
    }
}
