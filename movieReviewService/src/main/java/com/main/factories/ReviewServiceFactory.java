package com.main.factories;

import com.main.services.ReviewService;
import com.main.services.ReviewServiceImpl;

public class ReviewServiceFactory {

    private static ReviewService reviewService;

    public ReviewServiceFactory() {
        reviewService = null;
    }

    public ReviewService getReviewService() {

        if (reviewService == null) {
            reviewService = new ReviewServiceImpl();
        }
        return reviewService;
        
    }
    
}
