package com.audit.app.Admin_Services._Data_Forms.CreateAuditTimeTable.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;


/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class AuditTimeTableForm
{
    private int projectCode;
    private String auditor;
    private Date scheduledOn;
    private String auditee;
    private String remark;
    private boolean status;


    public int getProjectCode ()
    {
        return projectCode;
    }

    public void setProjectCode (final int projectCode)
    {
        this.projectCode = projectCode;
    }

    public String getAuditor ()
    {
        return auditor;
    }

    public void setAuditor (final String auditor)
    {
        this.auditor = auditor;
    }

    public Date getScheduledOn ()
    {
        return scheduledOn;
    }

    public void setScheduledOn (final Date scheduledOn)
    {
        this.scheduledOn = scheduledOn;
    }

    public String getAuditee ()
    {
        return auditee;
    }

    public void setAuditee (final String auditee)
    {
        this.auditee = auditee;
    }

    public String getRemark ()
    {
        return remark;
    }

    public void setRemark (final String remark)
    {
        this.remark = remark;
    }

    public boolean isStatus ()
    {
        return status;
    }

    public void setStatus (final boolean status)
    {
        this.status = status;
    }

    @Override
    public String toString ()
    {
        return "AuditTimeTableForm{" +
                "projectCode=" + projectCode +
                ", auditor='" + auditor + '\'' +
                ", scheduledOn=" + scheduledOn +
                ", auditee='" + auditee + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}
