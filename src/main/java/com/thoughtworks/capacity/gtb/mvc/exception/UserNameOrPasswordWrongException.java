package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.common.constants.ExceptionMessageConstants;

public class UserNameOrPasswordWrongException extends Exception{
    private String message = ExceptionMessageConstants.USER_NAME_OR_PASSWORD_WRONG;

    @Override
    public String getMessage() {
        return message;
    }
}
