package com.theatmoclub.quizdetail.dao;


import com.theatmoclub.databaseconncetion.dbconnection.DatabaseConnection;
import com.theatmoclub.exception.CustomException.ConnectionException;
import com.theatmoclub.quizdetail.model.Quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Crud Database</h1>
 *
 * <p>Database for Crud Operation</p>
 */
public class CrudDao {

    /**
     * Check first round question number
     *
     * @param questionNumber
     */
    public boolean checkFirstRoundQuestionNumber(final int questionNumber) {
        final String sqlQuery = "select question_number from first_round_table where question_number = ?";

        return checkQuestionNumber(questionNumber, sqlQuery);
    }

    /**
     * Check second round question number
     *
     * @param questionNumber
     */
    public boolean checkSecondRoundQuestionNumber(final int questionNumber) {
        final String sqlQuery = "select question_number from second_round_table where question_number = ?";

        return checkQuestionNumber(questionNumber, sqlQuery);
    }

    /**
     * Check third round question number
     *
     * @param questionNumber
     */
    public  boolean checkThirdRoundQuestionNumber(final int questionNumber) {
        final String sqlQuery = "select question_number from third_round_table where question_number = ?";

        return checkQuestionNumber(questionNumber, sqlQuery);
    }

    /**
     * Check question number from database
     *
     * @param questionNumber
     * @param sqlQuery
     */
    private boolean checkQuestionNumber(final int questionNumber, final String sqlQuery) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {
            prepareStatement.setInt(1, questionNumber);

            try (ResultSet resultSet = prepareStatement.executeQuery();) {

                while (resultSet.next()) {
                    return true;
                }
            }
        } catch(SQLException exception) {
            throw new ConnectionException("Connection Failed");
        }
        return false;
    }

    /**
     * Insert firstRoundDetails into firstRoundTable
     *
     * @param quizTools
     */
    public boolean insertFirstRound(final Quiz quizTools) {
        final String sqlQuery = "Insert Into first_round_table values(?, ?, ?, ?, ?, ?, ?)";

        return CrudDao.prepareStatementForInsertTable(sqlQuery, quizTools);
    }

    /**
     * Insert secondRoundDetails into secondRoundTable
     *
     * @param quizTools
     */
    public boolean insertSecondRound(final Quiz quizTools) {
        final String sqlQuery = "Insert Into second_round_table values(?, ?, ?, ?, ?, ?, ?)";

        return CrudDao.prepareStatementForInsertTable(sqlQuery, quizTools);
    }

    /**
     * Insert thirdRoundDetails into thirdRoundTable
     *
     * @param quizTools
     */
    public boolean insertThirdRound(final Quiz quizTools) {
        final String sqlQuery = "Insert Into third_round_table values(?, ?, ?, ?, ?, ?, ?)";

        return CrudDao.prepareStatementForInsertTable(sqlQuery, quizTools);
    }

    /**
     * Execute query using prepareStatement
     *
     * @param sqlQuery
     * @param quizTools
     */
    private static boolean prepareStatementForInsertTable(final String sqlQuery, final Quiz quizTools) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {

            prepareStatement.setInt(1, quizTools.getQuestionNumber());
            prepareStatement.setString(2, quizTools.getQuestions());
            prepareStatement.setString(3, quizTools.getFirstOption());
            prepareStatement.setString(4, quizTools.getSecondOption());
            prepareStatement.setString(5, quizTools.getThirdOption());
            prepareStatement.setString(6, quizTools.getFourthOption());
            prepareStatement.setString(7, quizTools.getCorrectAnswer());

            prepareStatement.executeUpdate();

            return true;
        } catch (SQLException exception) {
            throw new ConnectionException("Connection Failed");
        }
    }

    /**
     * Update firstRoundDetails into firstRoundTable
     *
     * @param quizTools
     */
    public boolean updateFirstRound(final Quiz quizTools) {
        final String sqlQuery = "Update first_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";

        return CrudDao.prepareStatementForUpdateTable(sqlQuery, quizTools);
    }

    /**
     * Update secondRoundDetails into secondRoundTable
     *
     * @param quizTools
     */
    public boolean updateSecondRound(final Quiz quizTools) {
        final String sqlQuery = "Update second_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";

        return CrudDao.prepareStatementForUpdateTable(sqlQuery, quizTools);
    }

    /**
     * Update thirdRoundDetails into thirdRoundTable
     *
     * @parma quizTools
     */
    public boolean updateThirdRound(final Quiz quizTools) {
        final String sqlQuery = "Update third_round_table SET questions = ?, first_option = ?, second_option = ?, third_option = ?, fourth_option = ?, correct_answer = ? WHERE question_number = ?";

        return CrudDao.prepareStatementForUpdateTable(sqlQuery, quizTools);
    }

    /**
     * Execute query using prepareStatement
     *
     * @param sqlQuery
     * @parma quizTools
     */
    public static boolean prepareStatementForUpdateTable(final String sqlQuery, final Quiz quizTools) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);) {

            prepareStatement.setString(1, quizTools.getQuestions());
            prepareStatement.setString(2, quizTools.getFirstOption());
            prepareStatement.setString(3, quizTools.getSecondOption());
            prepareStatement.setString(4, quizTools.getThirdOption());
            prepareStatement.setString(5, quizTools.getFourthOption());
            prepareStatement.setString(6, quizTools.getCorrectAnswer());
            prepareStatement.setInt(7, quizTools.getQuestionNumber());

            prepareStatement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            throw new ConnectionException("Connection Failed");
        }
    }

    /**
     * Delete firstRound from firstRoundTable
     *
     * @param questionNumber
     */
    public boolean deleteFirstRound(final int questionNumber) {
        final String sqlQuery = "Delete from first_round_table where question_number = ?";

        return CrudDao.prepareStatementForDeleteTable(sqlQuery, questionNumber);
    }

    /**
     * Delete secondRound from secondRoundTable
     *
     * @param questionNumber
     */
    public boolean deleteSecondRound(final int questionNumber) {
        final String sqlQuery = "Delete from second_round_table where question_number = ?";

        return CrudDao.prepareStatementForDeleteTable(sqlQuery, questionNumber);
    }

    /**
     * Delete thirdRound from thirdRoundTable
     *
     * @param questionNumber
     */
    public boolean deleteThirdRound(final int questionNumber) {
        final String sqlQuery = "Delete from third_round_table where question_number = ?";

        return CrudDao.prepareStatementForDeleteTable(sqlQuery, questionNumber);
    }

    /**
     * Execute query using PrepareStatement
     *
     * @param sqlQuery
     * @param questionNumber
     */
    private static boolean prepareStatementForDeleteTable(final String sqlQuery, final int questionNumber) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement prePareStatement = connection.prepareStatement(sqlQuery);) {

            prePareStatement.setInt(1, questionNumber);
            prePareStatement.executeUpdate();

            return true;
        } catch (SQLException exception) {
            throw new ConnectionException("Connection Failed");
        }
    }

    /**
     * Get firstRoundDetails
     */
    public List<Quiz> getFirstRoundDetails() {
        final String sqlQuery = "select question_number, questions, first_option,second_option, third_option, fourth_option, correct_answer from first_round_table";

        return CrudDao.getDetails(sqlQuery);
    }

    /**
     * Get secondRoundDetails
     */
    public List<Quiz> getSecondRoundDetails() {
        final String sqlQuery = "select question_number, questions, first_option,second_option, third_option, fourth_option, correct_answer from second_round_table";

        return CrudDao.getDetails(sqlQuery);

    }

    /**
     * Get thirdRoundDetails
     */
    public List<Quiz> getThirdRoundDetails() {
        final String sqlQuery = "select question_number, questions, first_option,second_option, third_option, fourth_option, correct_answer from third_round_table";

        return CrudDao.getDetails(sqlQuery);
    }

    /**
     * Get questions,options and correctAnswer from dataBase
     *
     * @param sqlQuery
     */
    public static List<Quiz> getDetails(final String sqlQuery) {

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            List<Quiz> questionDetails = new ArrayList<Quiz>();

            while (resultSet.next()) {
                final Quiz questionAnswer = new Quiz();

                questionAnswer.setQuestionNumber(resultSet.getInt(1));
                questionAnswer.setQuestions(resultSet.getString(2));
                questionAnswer.setFirstOption(resultSet.getString(3));
                questionAnswer.setSecondOption(resultSet.getString(4));
                questionAnswer.setThirdOption(resultSet.getString(5));
                questionAnswer.setFourthOption(resultSet.getString(6));
                questionAnswer.setCorrectAnswer(resultSet.getString(7));

                questionDetails.add(questionAnswer);
            }
            return questionDetails;
        } catch (SQLException exception) {
            throw new ConnectionException("Connection Failed");
        }
    }
}
