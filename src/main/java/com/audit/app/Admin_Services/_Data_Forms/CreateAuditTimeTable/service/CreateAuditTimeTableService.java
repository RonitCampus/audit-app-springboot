package com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.service;

import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model.AuditTimeTableForm;
import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model.ProjInfo;
import com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.repository.CreateAuditTimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class CreateAuditTimeTableService
{
    private final CreateAuditTimeTableRepository createAuditTimeTableRepository;

    @Autowired
    public CreateAuditTimeTableService (final CreateAuditTimeTableRepository createAuditTimeTableRepository)
    {
        this.createAuditTimeTableRepository = createAuditTimeTableRepository;
    }

    public List<ProjInfo> getProjects () throws SQLException
    {
        return this.createAuditTimeTableRepository.getProjects();
    }

    public boolean addProjecttoTimeTable (AuditTimeTableForm auditTimeTableForm) throws SQLException
    {
        return this.createAuditTimeTableRepository.addProjecttoTimeTable(auditTimeTableForm);
    }

}
