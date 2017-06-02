package com.audit.app.ncRegister.model.resposne;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class ProjectInfo
{
    private Integer id;
    private Integer auditId;
    private String name;
    private Date scheduledOn;
    private Date conductedOn;
    private String auditor;
    private String auditee;
    private String remark;
    private boolean status;

    public int getId ()
    {
        return id;
    }

    public void setId (final int id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (final String name)
    {
        this.name = name;
    }

    public Date getScheduledOn ()
    {
        return scheduledOn;
    }

    public void setScheduledOn (final Date scheduledOn)
    {
        this.scheduledOn = scheduledOn;
    }

    public Date getConductedOn ()
    {
        return conductedOn;
    }

    public void setConductedOn (final Date conductedOn)
    {
        this.conductedOn = conductedOn;
    }

    public String getAuditor ()
    {
        return auditor;
    }

    public void setAuditor (final String auditor)
    {
        this.auditor = auditor;
    }

    public String getAuditee ()
    {
        return auditee;
    }

    public void setAuditee (final String auditee)
    {
        this.auditee = auditee;
    }

    public int getAuditId ()
    {
        return auditId;
    }

    public void setAuditId (final int auditId)
    {
        this.auditId = auditId;
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
        return "Project{" +
                "id=" + id +
                ", auditId=" + auditId +
                ", name='" + name + '\'' +
                ", scheduledOn=" + scheduledOn +
                ", conductedOn=" + conductedOn +
                ", auditor='" + auditor + '\'' +
                ", auditee='" + auditee + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
