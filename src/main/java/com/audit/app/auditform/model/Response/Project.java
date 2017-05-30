package com.audit.app.auditform.model.Response;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class Project
{
    private int id;
    private String name;

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

    @Override
    public String toString ()
    {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
