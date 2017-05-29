package com.audit.app.questionbank.controller;

import com.audit.app.questionbank.models.Request.CreateNewQuestion;
import com.audit.app.questionbank.models.Response.QuestionCategory;
import com.audit.app.questionbank.service.QuestionBankService;
import org.apache.commons.logging.impl.SLF4JLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@RestController
@CrossOrigin
@RequestMapping ("audit-app/admin/question-bank")
public class QuestionBankController
{
    private static Logger logger = LoggerFactory.getLogger(SLF4JLog.class);
    private QuestionBankService questionBankService;

    @Autowired
    public QuestionBankController (final QuestionBankService questionBankService)
    {
        this.questionBankService = questionBankService;
    }


    @GetMapping ("/get-categories")
    public ResponseEntity<List<QuestionCategory>> getCategories () throws SQLException
    {
        return new ResponseEntity<>(this.questionBankService.getCategories(), HttpStatus.OK);
    }

    @PostMapping ("/add-question")
    public ResponseEntity<Boolean> addQuestion (@RequestBody CreateNewQuestion createNewQuestion) throws SQLException
    {
        logger.debug(String.valueOf(createNewQuestion));
        return new ResponseEntity<>(this.questionBankService.addQuestion(createNewQuestion), HttpStatus.OK);
    }
}
