package com.audit.app.Admin_Services._Data_Forms.ProjectMaster.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;


/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class ProjectMasterForm
{
    private String projectName;
    private String projectMgr;
    private String deliveryMgr;
    private String relationshipMgr;
    private String client;
    private String portfolio;
    private Date startDt;
    private Date endDt;
    private int projectType;
    private int associateCount;
    private boolean projectActiveStatus;

    public String getProjectName ()
    {
        return projectName;
    }

    public void setProjectName (final String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectMgr ()
    {
        return projectMgr;
    }

    public void setProjectMgr (final String projectMgr)
    {
        this.projectMgr = projectMgr;
    }

    public String getDeliveryMgr ()
    {
        return deliveryMgr;
    }

    public void setDeliveryMgr (final String deliveryMgr)
    {
        this.deliveryMgr = deliveryMgr;
    }

    public String getRelationshipMgr ()
    {
        return relationshipMgr;
    }

    public void setRelationshipMgr (final String relationshipMgr)
    {
        this.relationshipMgr = relationshipMgr;
    }

    public String getClient ()
    {
        return client;
    }

    public void setClient (final String client)
    {
        this.client = client;
    }

    public String getPortfolio ()
    {
        return portfolio;
    }

    public void setPortfolio (final String portfolio)
    {
        this.portfolio = portfolio;
    }

    public Date getStartDt ()
    {
        return startDt;
    }

    public void setStartDt (final Date startDt)
    {
        this.startDt = startDt;
    }

    public Date getEndDt ()
    {
        return endDt;
    }

    public void setEndDt (final Date endDt)
    {
        this.endDt = endDt;
    }

    public int getProjectType ()
    {
        return projectType;
    }

    public void setProjectType (final int projectType)
    {
        this.projectType = projectType;
    }

    public int getAssociateCount ()
    {
        return associateCount;
    }

    public void setAssociateCount (final int associateCount)
    {
        this.associateCount = associateCount;
    }

    public boolean isProjectActiveStatus ()
    {
        return projectActiveStatus;
    }

    public void setProjectActiveStatus (final boolean projectActiveStatus)
    {
        this.projectActiveStatus = projectActiveStatus;
    }

    @Override
    public String toString ()
    {
        return "ProjectMasterForm{" +
                "projectName='" + projectName + '\'' +
                ", projectMgr='" + projectMgr + '\'' +
                ", deliveryMgr='" + deliveryMgr + '\'' +
                ", relationshipMgr='" + relationshipMgr + '\'' +
                ", client='" + client + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", startDt=" + startDt +
                ", endDt=" + endDt +
                ", projectType=" + projectType +
                ", associateCount=" + associateCount +
                ", projectActiveStatus=" + projectActiveStatus +
                '}';
    }
}
