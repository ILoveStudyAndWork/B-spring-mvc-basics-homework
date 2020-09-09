package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNameOrPasswordWrongException extends Exception{
    private String message = "用户名或密码错误";

    @Override
    public String getMessage() {
        return message;
    }
}
