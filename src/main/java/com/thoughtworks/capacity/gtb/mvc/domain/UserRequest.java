package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    @Size(max = 10,min = 3,message = "用户名长度为3到10位")
    @NotEmpty(message = "用户名不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$",message = "只能由字母、数字或下划线组成")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(max = 12,min = 5,message = "密码，长度为5到12位")
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;

}
