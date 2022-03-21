package com.theatmoclub.quizdetail.controller;


import com.theatmoclub.quizdetail.model.Quiz;
import com.theatmoclub.quizdetail.service.DaoServiceImplements;
import com.theatmoclub.quizdetail.service.Daoservice;

import java.util.ArrayList;
import java.util.List;

public class CrudController {

    private static final Daoservice DAO_SERVICE = new DaoServiceImplements();

    /**
     * Questions insert into database
     *
     * @param quizTools
     */
    public boolean questionInsert(final Quiz quizTools, final int roundNumber) {
        return DAO_SERVICE.questionInsert(quizTools, roundNumber);
    }

    /**
     * Questions update into database
     *
     * @param quizTools
     */
    public boolean questionUpdate(final Quiz quizTools, final int roundNumber) {
        return DAO_SERVICE.questionUpdate(quizTools, roundNumber);
    }

    /**
     * Check question number
     *
     * @param questionNumber
     */

    public boolean checkQuestionNumber(final int questionNumber, final int roundNumber) {
        return DAO_SERVICE.checkQuestionNumber(questionNumber, roundNumber);
    }

    /**
     * Delete the questions
     *
     * @param questionNumber
     * @param roundNumber
     */
    public boolean questionDelete(final int questionNumber, final int roundNumber) {
        return DAO_SERVICE.deleteQuestion(questionNumber, roundNumber);
    }

    /**
     * Get first round details
     *
     */
    public static List<Quiz> getFirstRoundDetails() {
        return DAO_SERVICE.getFirstRoundDetails();
    }

    /**
     * Get second round details
     *
     */
    public static List<Quiz> getSecondRoundDetails() {
        return DAO_SERVICE.getSecondRoundDetails();
    }

    /**
     * Get third round details
     *
     */
    public static List<Quiz> getThirdRoundDetails() {
        return DAO_SERVICE.getThirdRoundDetails();
    }

}
