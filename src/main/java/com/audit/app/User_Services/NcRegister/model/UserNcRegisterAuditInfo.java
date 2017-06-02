package com.audit.app.User_Services.NcRegister.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class UserNcRegisterAuditInfo
{
    private int auditId;
    private String name;
    private String auditor;
    private String auditee;
    private String remark;
    private boolean status;
    private Date expectedCloseDt;

    public int getAuditId ()
    {
        return auditId;
    }

    public void setAuditId (final int auditId)
    {
        this.auditId = auditId;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (final String name)
    {
        this.name = name;
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

    public Date getExpectedCloseDt ()
    {
        return expectedCloseDt;
    }

    public void setExpectedCloseDt (final Date expectedCloseDt)
    {
        this.expectedCloseDt = expectedCloseDt;
    }

    @Override
    public String toString ()
    {
        return "NcRegisterAuditInfo{" +
                ", auditId=" + auditId +
                ", name='" + name + '\'' +
                ", auditor='" + auditor + '\'' +
                ", auditee='" + auditee + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", expectedCloseDt=" + expectedCloseDt +
                '}';
    }
}
