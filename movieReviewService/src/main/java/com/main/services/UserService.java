package com.main.services;

import java.util.List;

import com.main.dto.User;

public interface UserService {

    public User addUser(String user);

    public List<User> allUser();
    public User getUserByUserName(String user);
    
}
