package com.main.services;

import java.time.Year;
import java.util.List;

import com.main.Repository.MovieRepo;
import com.main.Repository.MovieRepoImpl;
import com.main.Repository.ReviewRepo;
import com.main.dto.Movie;
import com.main.dto.User;
import com.main.exceptions.WrongYearException;
import com.main.factories.MovieRepoFactory;
import com.main.factories.MovieServiceFactory;

public class MovieServiceImpl implements MovieService {

    private MovieRepo movieRepo;
    private MovieRepoFactory movieRepoFactory;

    public MovieServiceImpl() {
        movieRepoFactory = new MovieRepoFactory();
        movieRepo = movieRepoFactory.getMovieRepo();
    }

    @Override
    public Movie addMovie(String movieName, int year, List<String> genre) throws WrongYearException {
        
        Movie movie = new Movie(movieName,year,genre);
        movie = movieRepo.addMovie(movie);
        return movie;
    }

    @Override
    public int getMovieScoreByyear(Movie movie, int year) {
        
        return movieRepo.getMovieScoreByyear(movie, year);

    }

    public Movie getMovieByName(String name){

        return movieRepo.getMovieByName(name);

    }

    @Override
    public int getScore(Movie movie) {
        
        return movieRepo.getScore(movie);
        
    }

    
}
