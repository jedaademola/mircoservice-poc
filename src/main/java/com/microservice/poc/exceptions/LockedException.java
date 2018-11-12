package com.microservice.poc.exceptions;

/**
 * Created by Lukman.Arogundade on 11/04/2015.
 */
public class LockedException extends AbstractException {

    public LockedException(String code, String message) {
        super(code, message);
    }
}
