package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotExistException;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    static List<User> users;


    public UserRepository(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public Boolean contain(String username){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        return users.size();
    }

    public User getUserByUserName(String username) throws UserNotExistException {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUserName().equals(username)) {
                return users.get(i);
            }
        }
        throw new UserNotExistException();
    }
}
