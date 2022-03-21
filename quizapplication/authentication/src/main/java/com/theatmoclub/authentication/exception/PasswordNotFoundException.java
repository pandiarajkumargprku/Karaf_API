package com.theatmoclub.authentication.exception;

import com.theatmoclub.exception.CustomException;

public class PasswordNotFoundException extends CustomException {

    public PasswordNotFoundException(String message) {
        super(message);
    }
}
