package com.main.Repository;

import java.util.List;

import com.main.dto.Movie;
import com.main.dto.Review;
import com.main.dto.User;
import com.main.exceptions.MovieNotReleasedException;
import com.main.exceptions.UserAlreadyAddedReviewForMovieException;

public interface ReviewRepo {

    public Review addReview(Review review) throws UserAlreadyAddedReviewForMovieException,MovieNotReleasedException;

    public List<Movie> getReviewedMovieByUser(User user, String genre);
    
    
}
