package com.main.Repository;

import com.main.dto.Movie;

public interface MovieRepo {

    public Movie addMovie(Movie movie);
    public int getMovieScoreByyear(Movie movie, int year);
    public Movie getMovieByName(String movie);
    public int getScore(Movie movie);

    
}
