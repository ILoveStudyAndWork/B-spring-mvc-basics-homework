package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserExistException extends Error{
    private String message = "用户名已存在";

    @Override
    public String getMessage() {
        return message;
    }
}
