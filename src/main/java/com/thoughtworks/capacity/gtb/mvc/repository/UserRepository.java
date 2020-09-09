package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.UserRequest;
import com.thoughtworks.capacity.gtb.mvc.domain.User;

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

    public void delete(User user){
        users.remove(user);
    }

    public List<User> getAll(){
        return users;
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

}
