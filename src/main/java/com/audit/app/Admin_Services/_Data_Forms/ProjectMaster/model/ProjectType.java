package com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class ProjectType
{
    private int projectType;
    private String projectTypeDescription;

    public int getProjectType ()
    {
        return projectType;
    }

    public void setProjectType (final int projectType)
    {
        this.projectType = projectType;
    }

    public String getProjectTypeDescription ()
    {
        return projectTypeDescription;
    }

    public void setProjectTypeDescription (final String projectTypeDescription)
    {
        this.projectTypeDescription = projectTypeDescription;
    }

    @Override
    public String toString ()
    {
        return "ProjectTypeMaster{" +
                "projectType=" + projectType +
                ", projectTypeDescription='" + projectTypeDescription + '\'' +
                '}';
    }
}
