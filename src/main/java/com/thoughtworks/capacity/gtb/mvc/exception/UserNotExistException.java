package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.common.constants.ExceptionMessageConstants;

public class UserNotExistException extends Exception {
    private String message = ExceptionMessageConstants.USER_NOT_EXISTED;

    @Override
    public String getMessage() {
        return message;
    }
}
