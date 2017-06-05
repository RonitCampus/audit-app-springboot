package com.audit.app.questionbank.repository;

import com.audit.app.Db.DbConfig;
import com.audit.app.questionbank.models.Request.CreateNewQuestion;
import com.audit.app.questionbank.models.Response.QuestionCategoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Infocepts India in 2017.
 */
@Repository
public class QuestionBankRepository
{
    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public QuestionBankRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }

    public List<QuestionCategoryInfo> getCategories () throws SQLException
    {
        Statement statement = connection.createStatement();
        String sql = "select * from QuestionCategory";

        ResultSet resultSet = statement.executeQuery(sql);

        List<QuestionCategoryInfo> questionCategoryInfoList = new ArrayList<>();

        while (resultSet.next())
        {
            QuestionCategoryInfo questionCategoryInfo = this.applicationContext.getBean(QuestionCategoryInfo.class);

            questionCategoryInfo.setCateoryId(resultSet.getInt("Question_Category_Id"));
            questionCategoryInfo.setQuestionDescription(resultSet.getString("Question_Description"));

            questionCategoryInfoList.add(questionCategoryInfo);
        }

        return questionCategoryInfoList;

    }


    public boolean addQuestion (CreateNewQuestion createNewQuestion) throws SQLException
    {
        String sql = "insert into QuestionBank values(?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, createNewQuestion.getQuestionDescription());
        preparedStatement.setBoolean(2, createNewQuestion.getActiveStatus());
        preparedStatement.setInt(3, createNewQuestion.getCategory());
        preparedStatement.setInt(4, createNewQuestion.getWeightage());

        int rowsUpdated = preparedStatement.executeUpdate();

        System.out.println(rowsUpdated);

        return rowsUpdated > 0;

    }
}
