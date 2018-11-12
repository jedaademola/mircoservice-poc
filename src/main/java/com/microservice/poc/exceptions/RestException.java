package com.microservice.poc.exceptions;


public class RestException extends Exception {

    public RestException(String msg) {
        super(msg);
    }
}
