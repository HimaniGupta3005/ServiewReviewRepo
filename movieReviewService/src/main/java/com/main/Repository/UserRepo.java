package com.main.Repository;

import java.util.List;

import com.main.dto.User;

public interface UserRepo {

    public User addUser(String user);

    public void updateTitleToCritic(User user);

    public List<User> getAllUser();
    
    public User getUserByName(String name);
}
