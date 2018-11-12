package com.microservice.poc.exceptions;

public class RandomGeneratorUnavailableException extends AbstractException {

    public RandomGeneratorUnavailableException(String code, String message) {
        super(code, message);
    }
}
