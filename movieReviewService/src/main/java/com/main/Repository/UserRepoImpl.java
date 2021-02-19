package com.main.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.main.dto.User;

public class UserRepoImpl implements UserRepo {

    private List<User> userList;

    public UserRepoImpl() {
        userList = new ArrayList<User>();
    }
    @Override
    public User addUser(String userName) {
        
        User user;
        for(User u : userList) {
            if(u.getName().equals(userName)) {
                user = u;
                return user;
            }
        }
        user = new User(userName);
        user.setYear(LocalDate.now().getYear());
        userList.add(user);
    
        return user;
    }

    @Override
    public void updateTitleToCritic(User user) {
        
        user.setTitle("Critic");
        
    }

    @Override
    public List<User> getAllUser() {
        
        return userList;
    }
    
    @Override
    public User getUserByName(String name){

        for(User u : userList) {
            if(u.getName().equals(name)) 
                return u;
        }

        return null;
    }
}
