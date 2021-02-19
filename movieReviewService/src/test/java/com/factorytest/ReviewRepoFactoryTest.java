package com.factorytest;

import static org.junit.Assert.assertEquals;

import com.main.Repository.ReviewRepo;
import com.main.factories.ReviewRepoFactory;

import org.junit.Test;

public class ReviewRepoFactoryTest {
  
    @Test
    public void sameObjectToBeReturnedWhenCalledMultipleTimesTest() {

       ReviewRepoFactory factory = new ReviewRepoFactory();
       
       ReviewRepo reviewRepo = factory.getReviewRepo();

       assertEquals(reviewRepo, factory.getReviewRepo());
    }

    

}
