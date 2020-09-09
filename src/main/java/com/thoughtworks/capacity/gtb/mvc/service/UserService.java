package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.domain.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void register(UserRequest userRequest){
        if (userRepository.contain(userRequest.getUsername())){
            throw new UserExistException();
        }

        int id = userRepository.size();
        User user = User.builder()
                .id(id)
                .userName(userRequest.getUsername())
                .email(userRequest.getEmail())
                .passWord(userRequest.getPassword())
                .build();
        userRepository.addUser(user);
    }



}
