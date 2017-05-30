package com.audit.app.auditform.service;

import com.audit.app.auditform.model.Response.AuditQuestions;
import com.audit.app.auditform.model.Response.Project;
import com.audit.app.auditform.model.Response.StatusCodes;
import com.audit.app.auditform.repository.AuditFromRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class AuditFormService
{
    private AuditFromRepository auditFromRepository;

    @Autowired
    public AuditFormService (final AuditFromRepository auditFromRepository)
    {
        this.auditFromRepository = auditFromRepository;
    }

    public List<StatusCodes> getComplianceStatusCode () throws SQLException
    {
        return this.auditFromRepository.getComplianceStatusCode();
    }

    public List<Project> getAllProjects () throws SQLException
    {
        return this.auditFromRepository.getAllProjects();
    }

    public List<AuditQuestions> getAllQuestions (int projectId) throws SQLException
    {
        return this.auditFromRepository.getAllQuestions(projectId);
    }
}
