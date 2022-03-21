package com.theatmoclub.databaseconncetion.exception;

import com.theatmoclub.exception.CustomException;

public class ConnectionFailedException extends CustomException {

    public ConnectionFailedException(String message) {
        super(message);
    }
}
