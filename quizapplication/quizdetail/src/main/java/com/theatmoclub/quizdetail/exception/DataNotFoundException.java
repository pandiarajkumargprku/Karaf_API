package com.theatmoclub.quizdetail.exception;

import com.theatmoclub.exception.CustomException;

public class DataNotFoundException extends CustomException {

    public DataNotFoundException(String message) {
        super(message);
    }
}
