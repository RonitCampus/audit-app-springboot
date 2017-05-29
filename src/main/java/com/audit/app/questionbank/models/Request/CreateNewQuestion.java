package com.audit.app.questionbank.models.Request;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class CreateNewQuestion
{
    private String questionDescription;
    private Boolean activeStatus;
    private int category;
    private int weightage;


    public String getQuestionDescription ()
    {
        return questionDescription;
    }

    public void setQuestionDescription (final String questionDescription)
    {
        this.questionDescription = questionDescription;
    }

    public Boolean getActiveStatus ()
    {
        return activeStatus;
    }

    public void setActiveStatus (final Boolean activeStatus)
    {
        this.activeStatus = activeStatus;
    }

    public int getCategory ()
    {
        return category;
    }

    public void setCategory (final int category)
    {
        this.category = category;
    }

    public int getWeightage ()
    {
        return weightage;
    }

    public void setWeightage (final int weightage)
    {
        this.weightage = weightage;
    }

    @Override
    public String toString ()
    {
        return "CreateNewQuestion{" +
                "questionDescription='" + questionDescription + '\'' +
                ", activeStatus=" + activeStatus +
                ", category=" + category +
                ", weightage=" + weightage +
                '}';
    }
}
