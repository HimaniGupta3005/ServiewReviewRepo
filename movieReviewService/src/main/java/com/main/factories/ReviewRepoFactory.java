package com.main.factories;

import com.main.Repository.ReviewRepo;
import com.main.Repository.ReviewRepoImpl;

public class ReviewRepoFactory {

    private static ReviewRepo reviewRepo;

    public ReviewRepoFactory() {
        reviewRepo = null;
    }

    public ReviewRepo getReviewRepo() {
        if(reviewRepo == null) {
            reviewRepo = new ReviewRepoImpl();
        }
        return reviewRepo;
    }

    
}
