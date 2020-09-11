package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;

public class LoginParamsIllegalException extends Exception {
    private String message;
    private final HttpStatus httpStatus;

    @Override
    public String getMessage() {
        return message;

    }

    public LoginParamsIllegalException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
