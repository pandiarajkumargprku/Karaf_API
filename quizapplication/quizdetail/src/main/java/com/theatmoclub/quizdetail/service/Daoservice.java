package com.theatmoclub.quizdetail.service;

import com.theatmoclub.quizdetail.model.Quiz;

import java.util.List;

public interface Daoservice {

    boolean questionInsert(Quiz quizTools, int roundNumber);

    boolean questionUpdate(Quiz quizTools, int roundNumber);

    boolean checkQuestionNumber(int questionNumber, int roundNumber);

    boolean deleteQuestion(int questionNumber, int roundNumber);

    List<Quiz> getFirstRoundDetails();

    List<Quiz> getSecondRoundDetails();

    List<Quiz> getThirdRoundDetails();
}
