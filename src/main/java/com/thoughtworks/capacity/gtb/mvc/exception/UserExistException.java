package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.common.constants.ExceptionMessageConstants;

public class UserExistException extends Error{
    private String message = ExceptionMessageConstants.USER_EXISTED;

    @Override
    public String getMessage() {
        return message;
    }
}
