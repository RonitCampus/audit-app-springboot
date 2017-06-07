package com.audit.app.Admin_Services._Data_Forms.QuestionProject.service;

import com.audit.app.Admin_Services._Data_Forms.QuestionProject.model.AddDeleteQuestion;
import com.audit.app.Admin_Services._Data_Forms.QuestionProject.model.QuestionProject;
import com.audit.app.Admin_Services._Data_Forms.QuestionProject.repository.QuestionProjectRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class QuestionProjectService
{
    private final QuestionProjectRepositroy questionProjectRepositroy;

    @Autowired
    public QuestionProjectService (final QuestionProjectRepositroy questionProjectRepositroy)
    {
        this.questionProjectRepositroy = questionProjectRepositroy;
    }

    public List<QuestionProject> getAllQuestions (int projectType) throws SQLException
    {
        return this.questionProjectRepositroy.getAllQuestions(projectType);
    }

    public List<QuestionProject> getAllAvailableQuestion (int projectType) throws SQLException
    {
        return this.questionProjectRepositroy.getAllAvailableQuestion(projectType);
    }

    public boolean addQuestionToProjectType (AddDeleteQuestion addDeleteQuestion) throws SQLException
    {
        return this.questionProjectRepositroy.addQuestionToProjectType(addDeleteQuestion);
    }

    public boolean deleteQuestionFromProjectType (final AddDeleteQuestion addDeleteQuestion) throws SQLException
    {
        return this.questionProjectRepositroy.deleteQuestionFromProjectType(addDeleteQuestion);
    }
}
