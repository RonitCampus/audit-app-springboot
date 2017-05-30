package com.audit.app.auditform.model.Response;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class StatusCodes
{
    private int id;
    private String status;

    public int getId ()
    {
        return id;
    }

    public void setId (final int id)
    {
        this.id = id;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (final String status)
    {
        this.status = status;
    }

    @Override
    public String toString ()
    {
        return "StatusCodes{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
