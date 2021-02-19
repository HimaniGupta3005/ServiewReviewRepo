package com.main.factories;

import com.main.Repository.UserRepo;
import com.main.Repository.UserRepoImpl;

public class UserRepoFactory {

    private static UserRepo userRepo;

    public UserRepoFactory() {
        userRepo = null;
    }

    public UserRepo getUserRepo() {
        if(userRepo == null) {
            userRepo = new UserRepoImpl();
        }
            
        return userRepo;
    }
    
}
