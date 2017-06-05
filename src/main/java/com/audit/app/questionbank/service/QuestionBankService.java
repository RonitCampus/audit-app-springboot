package com.audit.app.questionbank.service;

import com.audit.app.questionbank.models.Request.CreateNewQuestion;
import com.audit.app.questionbank.models.Response.QuestionCategoryInfo;
import com.audit.app.questionbank.repository.QuestionBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Service
public class QuestionBankService
{
    private QuestionBankRepository questionBankRepository;

    @Autowired
    public QuestionBankService (QuestionBankRepository questionBankRepository)
    {
        this.questionBankRepository = questionBankRepository;
    }

    public List<QuestionCategoryInfo> getCategories () throws SQLException
    {
        return this.questionBankRepository.getCategories();
    }

    public boolean addQuestion (CreateNewQuestion createNewQuestion) throws SQLException
    {
        return this.questionBankRepository.addQuestion(createNewQuestion);
    }
}
