package com.microservice.poc.exceptions;


public class UnauthorizedException extends AbstractException {

    public UnauthorizedException(String code, String message) {
        super(code, message);
    }
}