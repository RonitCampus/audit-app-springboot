package com.audit.app.Admin_Services.ReviewNc.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by matth on 6/8/2017.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NcInfoUpdateForm {
    private int ncId;
    private String closedBy;
    private Date closeDate;
    private String closeRemark;

    public int getNcId() {
        return ncId;
    }

    public void setNcId(int ncId) {
        this.ncId = ncId;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getCloseRemark() {
        return closeRemark;
    }

    public void setCloseRemark(String closeRemark) {
        this.closeRemark = closeRemark;
    }

    @Override
    public String toString() {
        return "NcInfoUpdateForm{" +
                "ncId=" + ncId +
                ", closedBy='" + closedBy + '\'' +
                ", closeDate=" + closeDate +
                ", closeRemark='" + closeRemark + '\'' +
                '}';
    }
}
