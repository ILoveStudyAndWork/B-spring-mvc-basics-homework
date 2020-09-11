package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotExistException;

import java.util.ArrayList;
import java.util.List;
public class UserRepository {
    private static List<User> users;

    public UserRepository(){
        users = new ArrayList<>();
    }

    public void save(User user){
        users.add(user);
    }

    public boolean isExistByUsername(String username){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public int count(){
        return users.size();
    }

    public User findUserByUserName(String username) throws UserNotExistException {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        throw new UserNotExistException();
    }
}
