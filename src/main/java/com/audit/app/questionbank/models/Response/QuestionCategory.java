package com.audit.app.questionbank.models.Response;

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
    private int cateoryId;
    private String questionDescription;

    public int getCateoryId ()
    {
        return cateoryId;
    }

    public void setCateoryId (final int cateoryId)
    {
        this.cateoryId = cateoryId;
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
                "cateoryId=" + cateoryId +
                ", questionDescription='" + questionDescription + '\'' +
                '}';
    }
}
