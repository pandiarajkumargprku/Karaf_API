package com.theatmoclub.authentication.exception;

import com.theatmoclub.exception.CustomException;

public class MailIdNotFoundException extends CustomException {

    public MailIdNotFoundException(String message) {
        super(message);
    }
}
