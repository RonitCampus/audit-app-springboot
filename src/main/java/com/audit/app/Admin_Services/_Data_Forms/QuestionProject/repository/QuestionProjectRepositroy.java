package com.audit.app.Admin_Services._Data_Forms.QuestionProject.repository;

import com.audit.app.Admin_Services._Data_Forms.QuestionProject.model.AddDeleteQuestion;
import com.audit.app.Admin_Services._Data_Forms.QuestionProject.model.QuestionProject;
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
public class QuestionProjectRepositroy
{
    private ApplicationContext applicationContext;
    private Connection connection;

    @Autowired
    public QuestionProjectRepositroy (ApplicationContext applicationContext) throws SQLException
    {
        this.applicationContext = applicationContext;
        Connection connection = this.connection = DbConfig.getInstance();
    }

    @SuppressWarnings ("Duplicates")
    public List<QuestionProject> getAllQuestions (int projectType) throws SQLException
    {

        String sql = String.format("select qb.Question_Id, qb.Question_Description, qb.Active_Status, qc.Question_Description as Question_Category , qb.Weightage  from QuestionBank as qb inner join QuestionCategory as qc on qb.Category = qc.Question_Category_ID where qb.Question_Id in ( select Question_Id from QuestionProject where Project_Type = %s )", projectType);

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<QuestionProject> questionProjectList = new ArrayList<>();
        QuestionProject questionProject = null;

        while (resultSet.next())
        {
            questionProject = this.applicationContext.getBean(QuestionProject.class);
            questionProject.setQuestionId(resultSet.getInt("Question_Id"));
            questionProject.setQuestionDescription(resultSet.getString("Question_Description"));
            questionProject.setQuestionCategory(resultSet.getString("Question_Category"));
            questionProject.setActiveStatus(resultSet.getBoolean("Active_Status"));
            questionProject.setWeightage(resultSet.getInt("weightage"));

            questionProjectList.add(questionProject);
        }

        return questionProjectList;
    }

    @SuppressWarnings ("Duplicates")
    public List<QuestionProject> getAllAvailableQuestion (int projectType) throws SQLException
    {
        String sql = String.format("select qb.Question_Id, qb.Question_Description, qb.Active_Status, qc.Question_Description as Question_Category , qb.Weightage  from QuestionBank as qb inner join QuestionCategory as qc on qb.Category = qc.Question_Category_ID where qb.Question_Id not in ( select Question_Id from QuestionProject where Project_Type = %s )", projectType);

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<QuestionProject> questionProjectList = new ArrayList<>();
        QuestionProject questionProject = null;

        while (resultSet.next())
        {
            questionProject = this.applicationContext.getBean(QuestionProject.class);
            questionProject.setQuestionId(resultSet.getInt("Question_Id"));
            questionProject.setQuestionDescription(resultSet.getString("Question_Description"));
            questionProject.setQuestionCategory(resultSet.getString("Question_Category"));
            questionProject.setActiveStatus(resultSet.getBoolean("Active_Status"));
            questionProject.setWeightage(resultSet.getInt("weightage"));

            questionProjectList.add(questionProject);
        }

        return questionProjectList;
    }

    public boolean addQuestionToProjectType (AddDeleteQuestion addDeleteQuestion) throws SQLException
    {
        String sql = "insert into QuestionProject (Question_Id, Project_Type) values (?, ?);";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, addDeleteQuestion.getQuestionId());
        preparedStatement.setInt(2, addDeleteQuestion.getProjectType());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteQuestionFromProjectType (final AddDeleteQuestion addDeleteQuestion) throws SQLException
    {
        String sql = "delete from QuestionProject where Question_Id = ? and Project_Type = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, addDeleteQuestion.getQuestionId());
        preparedStatement.setInt(2, addDeleteQuestion.getProjectType());

        return preparedStatement.executeUpdate() > 0;
    }
}
