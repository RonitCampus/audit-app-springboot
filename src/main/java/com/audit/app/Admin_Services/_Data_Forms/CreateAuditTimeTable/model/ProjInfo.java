package com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class ProjInfo
{
    private int projectCode;
    private String projectName;
    private String projectManager;

    public int getProjectCode ()
    {
        return projectCode;
    }

    public void setProjectCode (final int projectCode)
    {
        this.projectCode = projectCode;
    }

    public String getProjectName ()
    {
        return projectName;
    }

    public void setProjectName (final String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectManager ()
    {
        return projectManager;
    }

    public void setProjectManager (final String projectManager)
    {
        this.projectManager = projectManager;
    }

    @Override
    public String toString ()
    {
        return "ProjInfo{" +
                "projectCode=" + projectCode +
                ", projectName='" + projectName + '\'' +
                ", projectManager='" + projectManager + '\'' +
                '}';
    }
}
