package com.main.controller;

import java.util.List;

import com.main.Repository.UserRepo;
import com.main.dto.Movie;
import com.main.dto.User;
import com.main.exceptions.MovieNotExistException;
import com.main.exceptions.MovieNotReleasedException;
import com.main.exceptions.UserAlreadyAddedReviewForMovieException;
import com.main.exceptions.UserNotExistException;
import com.main.exceptions.WrongYearException;
import com.main.factories.MovieServiceFactory;
import com.main.factories.ReviewServiceFactory;
import com.main.factories.UserServiceFactory;
import com.main.services.MovieService;
import com.main.services.ReviewService;
import com.main.services.UserService;

public class ReviewController {

    private UserService userService;
    private UserServiceFactory userServiceFactory;
    private ReviewService reviewService;
    private ReviewServiceFactory reviewServiceFactory;
    private MovieService movieService;
    private MovieServiceFactory movieServiceFactory;
    

    public ReviewController() {
        userServiceFactory = new UserServiceFactory();
        reviewServiceFactory = new ReviewServiceFactory();
        movieServiceFactory = new MovieServiceFactory();
        userService = userServiceFactory.getUserService();
        reviewService = reviewServiceFactory.getReviewService();
        movieService = movieServiceFactory.getMovieService();
    }

    public User addUser(String name) {
        return userService.addUser(name);
    }

    public List<User> getAllUser() {
        return userService.allUser();
    }
    public Movie addMovie(String name, int release, String genre) throws WrongYearException {
        Movie movie = new Movie(name, release, genre);

        return movieService.addMovie(name, release, genre);
    }

    public void giveReview(String userName, String movieName, int points)
            throws UserAlreadyAddedReviewForMovieException, MovieNotReleasedException, UserNotExistException,
            MovieNotExistException {
        
        User user = userService.getUserByUserName(userName);
        Movie movie = movieService.getMovieByName(movieName);

        if (user == null)
                throw new UserNotExistException();
        if (movie == null)
                throw new MovieNotExistException();
        reviewService.addReview(user, movie, points);


    }
    
    public List<Movie> getMovieByGenre(String genre,String userName) throws UserNotExistException {
        User user = userService.getUserByUserName(userName);
        
        if (user == null)
                throw new UserNotExistException();
        
        return reviewService.getReviewedMovieByUser(user, genre);

    }

    int getScoreOfMovieByYear(String movieName,int year) throws MovieNotExistException {

        Movie movie = movieService.getMovieByName(movieName);
        if (movie == null)
            throw new MovieNotExistException();
        
        return movieService.getMovieScoreByyear(movie, year);
    }

    public int getScore(String movieName) throws MovieNotExistException {

        Movie movie = movieService.getMovieByName(movieName);

        if (movie == null)
            throw new MovieNotExistException();
        
        return movieService.getScore(movie);


    }
    
}
