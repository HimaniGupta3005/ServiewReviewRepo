package com.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import com.main.dto.Movie;
import com.main.exceptions.WrongYearException;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {

    
    
    @Test
    public void createMovieObjectWithCorrectYearTest() {

        int year = 2006;
        String movieName = "padamavat";
        String genre = "comedy";
        Movie movie;
        List<String> list = new ArrayList<String>();
        list.add(genre);
        list.add("action");


        try {
            movie = new Movie(movieName, year, list);
        } catch (WrongYearException e) {
            movie = null;
        }

        assertNotEquals("Movie object not created",movie, null);

        assertEquals(movie.getGenre().get(0), genre.toUpperCase());
        assertEquals(movie.getGenre().get(1), "ACTION");
        assertEquals(movie.getMovieName(),movieName);
        assertEquals(movie.getRelease(), year);
        assertEquals(movie.getAverageScore(year), 0);
        assertEquals(movie.getScore(), 0);

    }

    @Test
    public void failWhenYearInvalidTest() {

        int year = 1400;
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

        assertEquals("Movie object should not be created",movie, null);

        year = 65981;
        
        try {
            movie = new Movie(movieName, year, list);
        } catch (WrongYearException e) {
            movie = null;
        }

        assertEquals("Movie object should not be created",movie, null);

    }

    @Test
    public void setScoreShouldUpdateScoreWhenYearValidTest() {

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

        movie.setScore(2006, 5);    

        assertEquals(movie.getAverageScore(2006), 5);
        movie.setScore(2006, 5);  
        assertEquals(movie.getAverageScore(2006), 5);
        movie.setScore(2007, 8);  
        assertEquals(movie.getAverageScore(2007), 8);
        movie.setScore(2007, 6);  
        assertEquals(movie.getAverageScore(2007), 7);

        assertEquals(movie.getTotalReview(),4);

    }

    @Test
    public void getScoreWhenNoReviewAddedTest() {

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

        assertEquals(movie.getScore(), 0);

    }

    @Test
    public void getScoreWhenReviewAddedTest() {

        int year = 2006;
        String movieName = "padamavat";
        String genre = "comedy";
        Movie movie;
        List<String> list = new ArrayList<String>();
        list.add(genre);
        try {
            movie = new Movie(movieName, year,list);
        } catch (WrongYearException e) {
            movie = null;
        }

        movie.setScore(2006, 50);
        movie.setScore(2007,150);
        
        assertEquals(movie.getScore(), 100);

    }





    

    
}
