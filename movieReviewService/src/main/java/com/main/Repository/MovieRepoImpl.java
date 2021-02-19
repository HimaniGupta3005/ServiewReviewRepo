package com.main.Repository;

import java.util.ArrayList;
import java.util.List;

import com.main.dto.Movie;
import com.main.factories.MovieRepoFactory;

public class MovieRepoImpl implements MovieRepo {

    private List<Movie> movieList;
    
    public MovieRepoImpl() {
        movieList = new ArrayList<Movie>();
    }

    @Override
    public Movie addMovie(Movie movie) {
        if(!movieList.contains(movie))
            movieList.add(movie);
        return movie;
    }

    public int getMovieScoreByyear(Movie movie, int year) {
        return movie.getAverageScore(year);
    }



    @Override
    public Movie getMovieByName(String movie) {
        
        for(Movie m : movieList) {
            if(m.getMovieName().equals(movie))
                return m;

        }


        return null;
    }

    @Override
    public int getScore(Movie movie) {
        
        return movie.getScore();
        
    }
    
}
