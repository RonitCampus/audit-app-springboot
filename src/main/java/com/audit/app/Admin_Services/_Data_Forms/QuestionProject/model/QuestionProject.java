package com.audit.app.Admin_Services._Data_Forms.QuestionProject.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class QuestionProject
{
    private int questionId;
    private String questionDescription;
    private boolean activeStatus;
    private String questionCategory;
    private int weightage;

    public int getQuestionId ()
    {
        return questionId;
    }

    public void setQuestionId (final int questionId)
    {
        this.questionId = questionId;
    }

    public String getQuestionDescription ()
    {
        return questionDescription;
    }

    public void setQuestionDescription (final String questionDescription)
    {
        this.questionDescription = questionDescription;
    }

    public boolean isActiveStatus ()
    {
        return activeStatus;
    }

    public void setActiveStatus (final boolean activeStatus)
    {
        this.activeStatus = activeStatus;
    }

    public String getQuestionCategory ()
    {
        return questionCategory;
    }

    public void setQuestionCategory (final String questionCategory)
    {
        this.questionCategory = questionCategory;
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
        return "QuestionProject{" +
                "questionId=" + questionId +
                ", questionDescription='" + questionDescription + '\'' +
                ", activeStatus=" + activeStatus +
                ", questionCategory='" + questionCategory + '\'' +
                ", weightage=" + weightage +
                '}';
    }
}
