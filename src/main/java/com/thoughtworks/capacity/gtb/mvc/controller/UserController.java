package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {


    UserService userService;

    public UserController(){
        userService = new UserService();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRequest userRequest){
        userService.register(userRequest);
        return ResponseEntity.ok().build();
    }
}
