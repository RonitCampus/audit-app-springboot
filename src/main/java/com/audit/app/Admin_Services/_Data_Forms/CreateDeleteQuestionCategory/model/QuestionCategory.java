package com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class QuestionCategory
{
    private int questionCategoryId;
    private String questionDescription;

    public int getQuestionCategoryId ()
    {
        return questionCategoryId;
    }

    public void setQuestionCategoryId (final int questionCategoryId)
    {
        this.questionCategoryId = questionCategoryId;
    }

    public String getQuestionDescription ()
    {
        return questionDescription;
    }

    public void setQuestionDescription (final String questionDescription)
    {
        this.questionDescription = questionDescription;
    }

    @Override
    public String toString ()
    {
        return "QuestionCategory{" +
                "questionCategoryId='" + questionCategoryId + '\'' +
                ", questionDescription='" + questionDescription + '\'' +
                '}';
    }
}
