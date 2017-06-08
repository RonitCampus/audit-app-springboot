package com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.service;

import com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.model.Nc;
import com.audit.app.Admin_Services._Data_Forms.AllNcsForProject.repository.AllNcForProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class AllNcsForProjectService
{

    private AllNcForProjectRepository allNcForProjectRepository;

    @Autowired
    public AllNcsForProjectService (final AllNcForProjectRepository allNcForProjectRepository)
    {
        this.allNcForProjectRepository = allNcForProjectRepository;
    }

    public List<Nc> getAllNcsForProject (final int projectId) throws SQLException
    {
        return this.allNcForProjectRepository.getAllNcsForProject(projectId);
    }
}
