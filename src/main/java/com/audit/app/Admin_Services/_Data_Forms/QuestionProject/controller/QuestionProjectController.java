package com.audit.app.Admin_Services._Data_Forms.QuestionProject.controller;

import com.audit.app.Admin_Services._Data_Forms.QuestionProject.model.AddDeleteQuestion;
import com.audit.app.Admin_Services._Data_Forms.QuestionProject.model.QuestionProject;
import com.audit.app.Admin_Services._Data_Forms.QuestionProject.service.QuestionProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping ("/Admin_Services/Data_forms/QuestionProject")
public class QuestionProjectController
{
    private final QuestionProjectService questionProjectService;

    @Autowired
    public QuestionProjectController (final QuestionProjectService questionProjectService)
    {
        this.questionProjectService = questionProjectService;
    }

    @GetMapping ("/allQuestions/{projectType}")
    public List<QuestionProject> getAllQuestions (@PathVariable ("projectType") int projectType) throws SQLException
    {
        return this.questionProjectService.getAllQuestions(projectType);
    }

    @GetMapping ("/allAvailableQuestions/{projectType}")
    public List<QuestionProject> getAllAvailableQuestions (@PathVariable ("projectType") int projectType) throws SQLException
    {
        return this.questionProjectService.getAllAvailableQuestion(projectType);
    }

    @PostMapping ("/addQuestionToProjectType")
    public boolean addQuestionToProjectType (@RequestBody AddDeleteQuestion addDeleteQuestion) throws SQLException
    {
        return this.questionProjectService.addQuestionToProjectType(addDeleteQuestion);
    }

    @PostMapping ("/deleteQuestionFromProjectType")
    public boolean deleteQuestionFromProjectType (@RequestBody AddDeleteQuestion addDeleteQuestion) throws SQLException
    {
        return this.questionProjectService.deleteQuestionFromProjectType(addDeleteQuestion);
    }

}
