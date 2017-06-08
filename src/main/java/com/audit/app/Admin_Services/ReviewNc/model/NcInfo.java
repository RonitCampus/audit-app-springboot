package com.audit.app.Admin_Services.ReviewNc.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class NcInfo
{
    private int ncId;
    private Date ncDate;
    private String raisedBy;
    private String assignedTo;
    private Date expectedCloseDate;
    private int status;
    private String description;
    private String resolution;
    private String projectName;

    public int getNcId ()
    {
        return ncId;
    }

    public void setNcId (final int ncId)
    {
        this.ncId = ncId;
    }

    public Date getNcDate ()
    {
        return ncDate;
    }

    public void setNcDate (final Date ncDate)
    {
        this.ncDate = ncDate;
    }

    public String getRaisedBy ()
    {
        return raisedBy;
    }

    public void setRaisedBy (final String raisedBy)
    {
        this.raisedBy = raisedBy;
    }

    public String getAssignedTo ()
    {
        return assignedTo;
    }

    public void setAssignedTo (final String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public Date getExpectedCloseDate ()
    {
        return expectedCloseDate;
    }

    public void setExpectedCloseDate (final Date expectedCloseDate)
    {
        this.expectedCloseDate = expectedCloseDate;
    }

    public int getStatus ()
    {
        return status;
    }

    public void setStatus (final int status)
    {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "NcInfo{" +
                "ncId=" + ncId +
                ", ncDate=" + ncDate +
                ", raisedBy='" + raisedBy + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", expectedCloseDate=" + expectedCloseDate +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", resolution='" + resolution + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
