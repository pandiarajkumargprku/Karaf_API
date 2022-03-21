package com.theatmoclub.userquizassessment.service;

import com.theatmoclub.userquizassessment.model.Quiz;

import java.util.List;

public interface QuizDaoService {
    List<Quiz> getFirstRoundDetails();

    List<Quiz> getSecondRoundDetails();

    List<Quiz> getThirdRoundDetails();

    boolean markInsert(int mark, String email);
}
