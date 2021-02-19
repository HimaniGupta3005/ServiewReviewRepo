package com.main.services;

import java.time.Year;

import com.main.dto.Movie;
import com.main.exceptions.WrongYearException;

public interface MovieService {
    
    public Movie addMovie(String movieName, int year, String genre) throws WrongYearException;
    public int getMovieScoreByyear(Movie movie, int year);
    public Movie getMovieByName(String movie);
    public int getScore(Movie movie);

}
