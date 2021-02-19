package com.main.services;

import java.util.List;

import com.main.dto.Movie;
import com.main.dto.Review;
import com.main.dto.User;
import com.main.exceptions.InvalidScoreException;
import com.main.exceptions.MovieNotExistException;
import com.main.exceptions.MovieNotReleasedException;
import com.main.exceptions.UserAlreadyAddedReviewForMovieException;

public interface ReviewService {

    public Review addReview(User user, Movie movie, int score)throws UserAlreadyAddedReviewForMovieException, 
        MovieNotReleasedException , InvalidScoreException 
    ;

    public List<Movie> getReviewedMovieByUser(User user,String genre);
    
}
