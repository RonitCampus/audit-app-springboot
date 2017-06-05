package com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.controller;

import com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.model.QuestionCategory;
import com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.service.CreateDeleteQuestionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */

@RestController
@CrossOrigin ()
@RequestMapping ("/Admin_Services/Data_forms/QuestionCategory")
public class CreateDeleteQuestionCategoryController
{

    private final CreateDeleteQuestionCategoryService createDeleteQuestionCategoryService;

    @Autowired
    public CreateDeleteQuestionCategoryController (final CreateDeleteQuestionCategoryService createDeleteQuestionCategoryService)
    {
        this.createDeleteQuestionCategoryService = createDeleteQuestionCategoryService;
    }

    @PostMapping ("/Add")
    public boolean addQuestionCategory (@RequestBody QuestionCategory questionCategory) throws SQLException
    {
        return this.createDeleteQuestionCategoryService.addQuestionCategory(questionCategory.getQuestionDescription());
    }

    @GetMapping ("/GetAll")
    public List<QuestionCategory> getAllQuestionCategories () throws SQLException
    {
        return this.createDeleteQuestionCategoryService.getAllQuestionCategories();
    }

    @DeleteMapping ("/Delete/{id}")
    public boolean deleteQuestionCategory (@PathVariable ("id") int id) throws SQLException
    {
        return this.createDeleteQuestionCategoryService.deleteQuestionCategory(id);
    }

}
