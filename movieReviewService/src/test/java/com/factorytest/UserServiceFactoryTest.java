package com.factorytest;

import static org.junit.Assert.assertEquals;

import com.main.factories.UserServiceFactory;
import com.main.services.UserService;

import org.junit.Test;

public class UserServiceFactoryTest {
    
    @Test 
    public void sameObjectToBeReturnedWhenCalledMultipleTimesTest() {

        UserServiceFactory factory = new UserServiceFactory();

        UserService userService = factory.getUserService();
        
        assertEquals(userService, factory.getUserService());

        assertEquals(userService, factory.getUserService());    

    }



}
