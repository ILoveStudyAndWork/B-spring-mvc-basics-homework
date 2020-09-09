package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.LoginRequest;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.domain.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginParamsNotValidException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameOrPasswordWrongException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotExistException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    private final static String USER_NOT_VALID = "用户名不合法";
    private final static String PASSWORD_NOT_VALID = "密码不合法";

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


    public User login(String username, String password) throws UserNotExistException, UserNameOrPasswordWrongException, LoginParamsNotValidException {
        validateParam(username,password);
        if (!userRepository.contain(username)){
            throw new UserNameOrPasswordWrongException();
        }
        User user = userRepository.getUserByUserName(username);
        if (user.getPassWord().equals(password)){
            return user;
        }
        else {
            throw new UserNameOrPasswordWrongException();
        }
    }

    void validateParam(String username, String password) throws LoginParamsNotValidException {
        String regex = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$";
        Boolean is = regex.matches(username);
        if (username.length() > 10 || username.length() < 3 || !username.matches(regex))
            throw new LoginParamsNotValidException(USER_NOT_VALID);
        if (password.length() > 12 || password.length() < 5 || !password.matches(regex))
            throw new LoginParamsNotValidException(PASSWORD_NOT_VALID);

    }

}
