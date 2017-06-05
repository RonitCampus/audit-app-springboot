package com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.repository;

import com.audit.app.Admin_Services._Data_Forms.CreateDeleteQuestionCategory.model.QuestionCategory;
import com.audit.app.Db.DbConfig;
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
public class CreateDeleteQuestionCategoryRepository
{

    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public CreateDeleteQuestionCategoryRepository (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }


    public boolean addQuestionCategory (String questionCategory) throws SQLException
    {
        String sql = "insert into QuestionCategory (Question_Description) values (?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, questionCategory);
        return preparedStatement.executeUpdate() > 0;
    }

    public List<QuestionCategory> getAllQuestionCategories () throws SQLException
    {

        String sql = "select * from QuestionCategory";
        Statement statement = this.connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        List<QuestionCategory> questionCategoryList = new ArrayList<>();

        QuestionCategory questionCategory = null;

        while (resultSet.next())
        {
            questionCategory = this.applicationContext.getBean(QuestionCategory.class);
            questionCategory.setQuestionCategoryId(resultSet.getInt("Question_Category_ID"));
            questionCategory.setQuestionDescription(resultSet.getString("Question_Description"));

            questionCategoryList.add(questionCategory);
        }
        return questionCategoryList;
    }

    public boolean deleteQuestionCategory (int id) throws SQLException
    {
        String sql = String.format("delete from QuestionCategory where Question_Category_ID = %s", id);
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        return preparedStatement.executeUpdate() > 0;
    }

}
