package com.theatmoclub.userquizassessment.service;

import com.theatmoclub.userquizassessment.exception.AccessFailedException;
import com.theatmoclub.userquizassessment.model.Quiz;
import com.theatmoclub.userquizassessment.dao.QuizDao;

import java.util.List;

public class QuizDaoServiceImplements implements QuizDaoService {

    private static final QuizDao QUIZ_DAO = new QuizDao();

    /**
     * Mark Insert into dataBase
     *
     * @param mark
     * @param email
     */
    public boolean markInsert(final int mark, final String email) {

        if (QUIZ_DAO.checkUserEmail(email)) {
            QUIZ_DAO.markInsert(mark, email);
        } else {
            return false;
        }
        return true;
    }

    /**
     * get first round details from dataBase
     * @return
     */
    public List<Quiz> getFirstRoundDetails() {
        return QUIZ_DAO.getFirstRoundDetails();
    }

    /**
     * get second round details from dataBase
     * @return
     */
    public List<Quiz> getSecondRoundDetails() {
        return QUIZ_DAO.getSecondRoundDetails();
    }

    /**
     * get third round details from dataBase
     * @return
     */
    public List<Quiz> getThirdRoundDetails() {
        return QUIZ_DAO.getThirdRoundDetails();
    }
}
