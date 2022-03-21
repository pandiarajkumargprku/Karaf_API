package com.theatmoclub.quizdetail.controller;

import com.theatmoclub.quizdetail.model.Quiz;

import java.util.List;

public interface Api {

    List<Quiz> getFirstRoundDetails(int start, int size);

    List<Quiz> getSecondRoundDetails();

    List<Quiz> getThirdRoundDetails();

    boolean questionDelete(final int questionNumber, final int roundNumber);

    boolean questionInsert(final Quiz quizTools, final int roundNumber);

    boolean questionUpdate(final Quiz quizTool, final int roundNumber);
}
