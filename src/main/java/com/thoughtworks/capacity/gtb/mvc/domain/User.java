package com.thoughtworks.capacity.gtb.mvc.domain;

import com.thoughtworks.capacity.gtb.mvc.common.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    @Size(max = 10,min = 3,message = ExceptionMessageConstants.USER_NAME_LENGTH_ERROR)
    @NotEmpty(message = ExceptionMessageConstants.USER_NAME_CAN_NOT_BE_NOT)
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$",message = ExceptionMessageConstants.USER_CONTENT_ERROR)
    private String username;

    @NotEmpty(message = ExceptionMessageConstants.PASSWORD_CAN_NOT_BE_NOT)
    @Size(max = 12,min = 5,message = ExceptionMessageConstants.PASSWORD_LENGTH_ERROR)
    private String password;

    @Email(message = ExceptionMessageConstants.ILLEGAL_EMAIL)
    private String email;

}
