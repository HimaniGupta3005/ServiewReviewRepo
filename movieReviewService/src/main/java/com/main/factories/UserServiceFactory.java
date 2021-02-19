package com.main.factories;

import com.main.services.UserService;
import com.main.services.UserServiceImpl;

public class UserServiceFactory {

    private static UserService userService;

    public UserServiceFactory(){
        userService = null;
    }

    public UserService getUserService() {
        if(userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
