package com.theatmoclub.userquizassessment.controller;

import com.theatmoclub.userquizassessment.model.Quiz;
import com.theatmoclub.userquizassessment.service.QuizDaoService;
import com.theatmoclub.userquizassessment.service.QuizDaoServiceImplements;

import java.util.List;

public class QuizController {

    private static final QuizDaoService QUIZ_DAO_SERVICE = new QuizDaoServiceImplements();

    /**
     * first level questions get from the database
     *
     */
    public static List<Quiz> getFirstRoundDetails() {
        return QUIZ_DAO_SERVICE.getFirstRoundDetails();
    }

    /**
     * second level questions get from the database
     *
     */
    public static List<Quiz> getSecondRoundDetails() {
        return QUIZ_DAO_SERVICE.getSecondRoundDetails();
    }

    /**
     * third level questions get from the database
     *
     */
    public static List<Quiz> getThirdRoundDetails() {
        return QUIZ_DAO_SERVICE.getThirdRoundDetails();
    }

    /**
     * User mark insert in to database
     *
     * @param mark
     * @param email
     */
    public static boolean markInsert(final int mark, final String email) {
        return QUIZ_DAO_SERVICE.markInsert(mark, email);
    }
}
