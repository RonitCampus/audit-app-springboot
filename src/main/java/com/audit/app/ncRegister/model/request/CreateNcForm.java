package com.audit.app.ncRegister.model.request;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class CreateNcForm
{
    private int auditId;
    private String projectName;
    private String raisedBy;
    private String assignedTo;
    private Date ncDate;
    private String description;
    private Date expectedCloseDate;

    public int getAuditId ()
    {
        return auditId;
    }

    public void setAuditId (final int auditId)
    {
        this.auditId = auditId;
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

    public Date getNcDate ()
    {
        return ncDate;
    }

    public void setNcDate (final Date ncDate)
    {
        this.ncDate = ncDate;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (final String description)
    {
        this.description = description;
    }

    public String getProjectName ()
    {
        return projectName;
    }

    public void setProjectName (final String projectName)
    {
        this.projectName = projectName;
    }

    public Date getExpectedCloseDate ()
    {
        return expectedCloseDate;
    }

    public void setExpectedCloseDate (final Date expectedCloseDate)
    {
        this.expectedCloseDate = expectedCloseDate;
    }

    @Override
    public String toString ()
    {
        return "CreateNcForm{" +
                "auditId=" + auditId +
                ", projectName='" + projectName + '\'' +
                ", raisedBy='" + raisedBy + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", ncDate=" + ncDate +
                ", description='" + description + '\'' +
                ", expectedCloseDate=" + expectedCloseDate +
                '}';
    }
}
