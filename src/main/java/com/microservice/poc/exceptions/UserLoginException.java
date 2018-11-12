package com.microservice.poc.exceptions;


public class UserLoginException extends AbstractException {

    public UserLoginException(String code, String message) {
        super(code, message);
    }
}
