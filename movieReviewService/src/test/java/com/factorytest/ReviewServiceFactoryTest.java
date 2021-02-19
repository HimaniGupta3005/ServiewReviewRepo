package com.factorytest;

import static org.junit.Assert.assertEquals;

import com.main.factories.ReviewServiceFactory;
import com.main.services.ReviewService;

import org.junit.Test;

public class ReviewServiceFactoryTest {

    @Test
    public void sameObjectToBeReturnedWhenCalledMultipleTimesTest() {

        ReviewServiceFactory factory = new ReviewServiceFactory();
        ReviewService reviewService = factory.getReviewService();

        assertEquals(factory.getReviewService(),reviewService);

    }
    
}
