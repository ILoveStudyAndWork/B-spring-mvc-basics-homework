package com.thoughtworks.capacity.gtb.mvc.exception;

public class LoginParamsNotValidException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public LoginParamsNotValidException(String message) {
        this.message = message;
    }

}
