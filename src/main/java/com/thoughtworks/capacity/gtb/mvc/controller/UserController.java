package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.domain.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username,
                                      @RequestParam String password) throws Exception {
        return ResponseEntity.ok(userService.login(username,password));

    }
}
