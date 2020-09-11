package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.common.constants.ExceptionMessageConstants;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
@RestController
public class UserController {

    UserService userService;

    public UserController(){
        userService = new UserService();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user){
        userService.register(user);
    }

    @GetMapping("/login")
    public User login(@RequestParam
                      @Size(max = 10,min = 3,message = ExceptionMessageConstants.USER_NAME_NOT_VALID)
                      @NotEmpty(message = ExceptionMessageConstants.USER_NAME_NOT_VALID)
                      @Pattern(regexp = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$",message = ExceptionMessageConstants.USER_NAME_NOT_VALID)
                          String username,
                      @RequestParam
                      @NotEmpty(message = ExceptionMessageConstants.PASSWORD_NOT_VALID)
                      @Size(max = 12,min = 5,message = ExceptionMessageConstants.PASSWORD_NOT_VALID)
                          String password) throws Exception {
        return userService.login(username,password);

    }
}
