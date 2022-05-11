package com.revature.whatdadogdoin.exceptions;

public class InvalidRequestException extends RuntimeException{

    public InvalidRequestException(String message) {
        super(message);
    }
}
