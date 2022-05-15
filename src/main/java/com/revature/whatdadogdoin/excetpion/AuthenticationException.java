package com.revature.whatdadogdoin.excetpion;

public class AuthenticationException extends RuntimeException{

    public AuthenticationException(String message){
        super(message);
    }

}
