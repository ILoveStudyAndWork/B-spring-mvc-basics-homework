package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNotExistException extends Exception {
    private String message = "用户名不存在";

    @Override
    public String getMessage() {
        return message;
    }
}
