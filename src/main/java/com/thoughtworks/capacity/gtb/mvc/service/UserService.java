package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginParamsIllegalException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPasswordWrongException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void register(User user){
        if (userRepository.isExistByUsername(user.getUsername())){
            throw new UserExistException();
        }
        int id = userRepository.count();
        user.setId(id);
        userRepository.save(user);
    }


    public User login(String username, String password) throws Exception {
        if (!userRepository.isExistByUsername(username)){
            throw new UserNameOrPasswordWrongException();
        }
        User user = userRepository.findUserByUserName(username);
        if (password.equals(user.getPassword())){
            return user;
        }
        else {
            throw new UserNameOrPasswordWrongException();
        }
    }


}
