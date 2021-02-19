package com.main.factories;

import com.main.Repository.MovieRepo;
import com.main.Repository.MovieRepoImpl;

public class MovieRepoFactory {

    private static MovieRepo movieRepo;

    public MovieRepoFactory() {
        movieRepo = null;
    }
    public MovieRepo getMovieRepo() {

        if(movieRepo == null) {
            movieRepo = new MovieRepoImpl();
        }
        
        return movieRepo;
    }

    
}
