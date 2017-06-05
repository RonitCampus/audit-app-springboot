package com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.service;

import com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.model.QuestionCategory;
import com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.repository.CreateDeleteQuestionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class CreateDeleteQuestionCategoryService
{

    private final CreateDeleteQuestionCategoryRepository createDeleteQuestionCategoryRepository;

    @Autowired
    public CreateDeleteQuestionCategoryService (final CreateDeleteQuestionCategoryRepository createDeleteQuestionCategoryRepository)
    {
        this.createDeleteQuestionCategoryRepository = createDeleteQuestionCategoryRepository;
    }

    public boolean addQuestionCategory (String questionCategory) throws SQLException
    {
        return this.createDeleteQuestionCategoryRepository.addQuestionCategory(questionCategory);
    }

    public List<QuestionCategory> getAllQuestionCategories () throws SQLException
    {
        return this.createDeleteQuestionCategoryRepository.getAllQuestionCategories();
    }

    public boolean deleteQuestionCategory (int id) throws SQLException
    {
        return this.createDeleteQuestionCategoryRepository.deleteQuestionCategory(id);
    }

}
