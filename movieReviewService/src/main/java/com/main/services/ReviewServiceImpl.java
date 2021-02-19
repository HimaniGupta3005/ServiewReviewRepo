package com.main.services;

import java.util.List;

import com.main.exceptions.MovieNotReleasedException;
import com.main.exceptions.UserAlreadyAddedReviewForMovieException;
import com.main.factories.ReviewRepoFactory;
import com.main.Repository.ReviewRepo;
import com.main.Repository.ReviewRepoImpl;
import com.main.dto.Movie;
import com.main.dto.Review;
import com.main.dto.User;
import com.main.exceptions.InvalidScoreException;
import com.main.exceptions.MovieNotExistException;

public class ReviewServiceImpl implements ReviewService {

    private ReviewRepo reviewRepo;
    private ReviewRepoFactory reviewRepoFactory;

    public ReviewServiceImpl() {
        reviewRepoFactory = new ReviewRepoFactory();
        reviewRepo = reviewRepoFactory.getReviewRepo();
    }

    @Override
    public Review addReview(User user, Movie movie, int score)
            throws UserAlreadyAddedReviewForMovieException, MovieNotReleasedException, InvalidScoreException {

        if(score >= 1 && score <= 10) {
            
            Review review = new Review(user, movie, score);
            review = reviewRepo.addReview(review);
            return review;
        }
        throw new InvalidScoreException();
        
    }

    @Override
    public List<Movie> getReviewedMovieByUser(User user,String genre) {
        
        return reviewRepo.getReviewedMovieByUser(user,genre);
    }
    
}
