package com.repositorytest;

import static org.junit.Assert.assertEquals;

import com.main.Repository.UserRepo;
import com.main.Repository.UserRepoImpl;

import org.junit.Test;

public class UserRepoImplTest {
    
    @Test
    public void addUserTest() {

        UserRepo userRepo = new UserRepoImpl();

        assertEquals(userRepo.addUser("srk").getName(),"srk");
        assertEquals(userRepo.addUser("salman").getName(),"salman");
        assertEquals(userRepo.addUser("srk").getYear(),2021);
        
    }

    @Test
    public void getUserByNameTest() {

        UserRepo userRepo = new UserRepoImpl();

        assertEquals(userRepo.addUser("srk").getName(),"srk");
        assertEquals(userRepo.addUser("salman").getName(),"salman");
        assertEquals(userRepo.addUser("srk").getYear(),2021);

        assertEquals(userRepo.getAllUser().size(), 2);
        assertEquals(userRepo.getAllUser().get(0).getName(), "srk");
        assertEquals(userRepo.getUserByName("himani"), null);
        assertEquals(userRepo.getUserByName("srk").getName(), "srk");
        

    }


}
