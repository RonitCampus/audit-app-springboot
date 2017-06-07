package com.audit.app.Admin_Services._Data_Forms.QuestionProject.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Infocepts India in 2017.
 */
@Component
@Scope (BeanDefinition.SCOPE_PROTOTYPE)
public class AddDeleteQuestion
{
    private int questionId;
    private int projectType;

    public int getQuestionId ()
    {
        return questionId;
    }

    public void setQuestionId (final int questionId)
    {
        this.questionId = questionId;
    }

    public int getProjectType ()
    {
        return projectType;
    }

    public void setProjectType (final int projectType)
    {
        this.projectType = projectType;
    }

    @Override
    public String toString ()
    {
        return "AddQuestion{" +
                "questionId=" + questionId +
                ", projectType=" + projectType +
                '}';
    }
}
