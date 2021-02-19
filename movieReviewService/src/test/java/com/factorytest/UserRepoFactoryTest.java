package com.factorytest;

import static org.junit.Assert.assertEquals;

import com.main.Repository.UserRepo;
import com.main.factories.UserRepoFactory;

import org.junit.Test;

public class UserRepoFactoryTest {

    @Test
    public void sameObjectToBeReturnedWhenCalledMultipleTimesTest() {

        UserRepoFactory factory = new UserRepoFactory();

        UserRepo userRepo = factory.getUserRepo();

        assertEquals(userRepo, factory.getUserRepo());
    }
    
}
