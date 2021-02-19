package com.repositorytest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.main.Repository.MovieRepo;
import com.main.Repository.MovieRepoImpl;
import com.main.dto.Movie;
import com.main.exceptions.WrongYearException;

import org.junit.Test;
import org.mockito.Mock;

public class MovieRepoImplTest {

    private Movie movie;

    @Test
    public void addMovieTest() {

        int year = 2006;
        String movieName = "padamavat";
        String genre = "comedy";
        Movie movie;
        List<String> list = new ArrayList<String>();
        list.add(genre);

        try {
            movie = new Movie(movieName, year, list);
        } catch (WrongYearException e) {
            movie = null;
        }
        
        MovieRepo repo = new MovieRepoImpl();
        repo.addMovie(movie);

        assertEquals(movie, repo.getMovieByName(movieName));
        assertEquals(null, repo.getMovieByName("himani"));
        repo.addMovie(movie);
        repo.addMovie(movie);
        repo.addMovie(movie);
        assertEquals(movie, repo.getMovieByName(movieName));
        assertEquals(null, repo.getMovieByName("himani"));

        assertEquals(movie.getScore(), 0);

    }


    
}
