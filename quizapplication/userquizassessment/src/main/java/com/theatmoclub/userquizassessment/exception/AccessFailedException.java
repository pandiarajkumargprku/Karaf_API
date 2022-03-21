package com.theatmoclub.userquizassessment.exception;

import com.theatmoclub.exception.CustomException;

public class AccessFailedException extends CustomException {

    public AccessFailedException(String message) {
        super(message);
    }
}
