package com.main.services;

import java.util.List;

import com.main.Repository.UserRepo;
import com.main.Repository.UserRepoImpl;
import com.main.dto.User;
import com.main.factories.UserRepoFactory;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private UserRepoFactory userRepoFactory;

    public UserServiceImpl() {
        userRepoFactory = new UserRepoFactory();
        userRepo = userRepoFactory.getUserRepo();
    }

    @Override
    public User addUser(String user) {

        return userRepo.addUser(user);

    }

    @Override
    public List<User> allUser() {
        return userRepo.getAllUser();
    }

    public User getUserByUserName(String name) {

        return userRepo.getUserByName(name);

    }

    
}
