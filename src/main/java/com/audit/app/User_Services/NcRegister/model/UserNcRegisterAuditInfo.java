package com.audit.app.User_Services.NcRegister.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;


/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class UserNcRegisterAuditInfo
{
    private int ncId;
    private int auditId;
    private String projectName;
    private String raisedBy;
    private Date expectedCloseDate;
    private String assignedTo;
    private String ncDescription;
    private int ncStatus;

    public int getNcId ()
    {
        return ncId;
    }

    public void setNcId (final int ncId)
    {
        this.ncId = ncId;
    }

    public int getAuditId ()
    {
        return auditId;
    }

    public void setAuditId (final int auditId)
    {
        this.auditId = auditId;
    }

    public String getProjectName ()
    {
        return projectName;
    }

    public void setProjectName (final String projectName)
    {
        this.projectName = projectName;
    }

    public String getRaisedBy ()
    {
        return raisedBy;
    }

    public void setRaisedBy (final String raisedBy)
    {
        this.raisedBy = raisedBy;
    }

    public Date getExpectedCloseDate ()
    {
        return expectedCloseDate;
    }

    public void setExpectedCloseDate (final Date expectedCloseDate)
    {
        this.expectedCloseDate = expectedCloseDate;
    }

    public String getAssignedTo ()
    {
        return assignedTo;
    }

    public void setAssignedTo (final String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public String getNcDescription ()
    {
        return ncDescription;
    }

    public void setNcDescription (final String ncDescription)
    {
        this.ncDescription = ncDescription;
    }

    public int getNcStatus ()
    {
        return ncStatus;
    }

    public void setNcStatus (final int ncStatus)
    {
        this.ncStatus = ncStatus;
    }

    @Override
    public String toString ()
    {
        return "UserNcRegisterAuditInfo{" +
                "ncId=" + ncId +
                ", auditId=" + auditId +
                ", projectName='" + projectName + '\'' +
                ", raisedBy='" + raisedBy + '\'' +
                ", expectedCloseDate=" + expectedCloseDate +
                ", assignedTo='" + assignedTo + '\'' +
                ", ncDescription='" + ncDescription + '\'' +
                ", ncStatus=" + ncStatus +
                '}';
    }
}
