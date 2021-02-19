package com.main.factories;

import com.main.services.MovieService;
import com.main.services.MovieServiceImpl;

public class MovieServiceFactory {

    private static MovieService movieService;

    public MovieServiceFactory() {
        movieService = null;
    }

    public MovieService getMovieService() {
        if(movieService == null) {
            movieService = new MovieServiceImpl();
        }
        return movieService;
    }
    
}
