package com.theatmoclub.quizdetail.service;


import com.theatmoclub.quizdetail.dao.CrudDao;
import com.theatmoclub.quizdetail.model.Quiz;
import com.theatmoclub.quizdetail.exception.DataNotFoundException;
import com.theatmoclub.quizdetail.exception.IdAlreayExistsException;

import java.util.List;

/**
 * <h1>Service Implements</h1>
 *
 * <p>Service Implementation for Crud operation</p>
 */
public class DaoServiceImplements implements Daoservice {

    private static final CrudDao CRUD_DAO = new CrudDao();

    /**
     * check questionNumber
     *
     * @param questionNumber
     * @param roundNumber
     */
    public  boolean checkQuestionNumber(final int questionNumber, final int roundNumber) {
        boolean isRoundNumber = true;

        if(roundNumber == 1) {
            isRoundNumber = CRUD_DAO.checkFirstRoundQuestionNumber(questionNumber);
        } else if(roundNumber == 2) {
            isRoundNumber = CRUD_DAO.checkSecondRoundQuestionNumber(questionNumber);
        } else if(roundNumber == 3) {
            isRoundNumber = CRUD_DAO.checkThirdRoundQuestionNumber(questionNumber);
        }
        return isRoundNumber;
    }

    /**
     * check round number to insert the question
     * @param quizTools
     * @param roundNumber
     */
    public  boolean questionInsert(Quiz quizTools, final int roundNumber) {
        boolean isQuestionInsert = true;

        if(roundNumber == 1) {
            isQuestionInsert = CRUD_DAO.insertFirstRound(quizTools);
        } else if(roundNumber == 2) {
            isQuestionInsert = CRUD_DAO.insertSecondRound(quizTools);
        } else if(roundNumber == 3) {
            isQuestionInsert = CRUD_DAO.insertThirdRound(quizTools);
        } else {
            throw new IdAlreayExistsException("Question Number Already Exits");
        }
        return isQuestionInsert;
    }

    /**
     * check round number to update the question
     * @param quizTools
     * @param roundNumber
     */
    public boolean questionUpdate(Quiz quizTools, final int roundNumber) {
        boolean isQuestionUpdate = true;

        if(roundNumber == 1) {
            isQuestionUpdate = CRUD_DAO.updateFirstRound(quizTools);
        } else if(roundNumber == 2) {
            isQuestionUpdate = CRUD_DAO.updateSecondRound(quizTools);
        } else if(roundNumber == 3) {
            isQuestionUpdate = CRUD_DAO.updateThirdRound(quizTools);
        } else {
            throw new DataNotFoundException("Question Not Found");
        }
        return isQuestionUpdate;
    }

    /**
     * check round number to delete the question
     * @param questionNumber
     * @param roundNumber
     */
    public boolean deleteQuestion(final int questionNumber, final int roundNumber) {
        boolean isQuestionDelete = true;

        if(roundNumber == 1) {
            isQuestionDelete = CRUD_DAO.deleteFirstRound(questionNumber);
        } else if(roundNumber == 2) {
            isQuestionDelete = CRUD_DAO.deleteSecondRound(questionNumber);
        } else if(roundNumber == 3) {
            isQuestionDelete = CRUD_DAO.deleteThirdRound(questionNumber);
        } else {
            throw new DataNotFoundException("Question Not Found");
        }
        return isQuestionDelete;
    }

    /**
     * get first round details from dataBase
     * @return
     */
    public List<Quiz> getFirstRoundDetails() {
        return CRUD_DAO.getFirstRoundDetails();
    }

    /**
     * get second round details from dataBase
     * @return
     */
    public List<Quiz> getSecondRoundDetails() {
        return CRUD_DAO.getSecondRoundDetails();
    }

    /**
     * get third round details from dataBase
     * @return
     */
    public List<Quiz> getThirdRoundDetails() {
        return CRUD_DAO.getThirdRoundDetails();
    }
}
