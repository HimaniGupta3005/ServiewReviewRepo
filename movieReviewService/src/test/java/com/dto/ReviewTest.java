package com.dto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import com.main.dto.Movie;
import com.main.dto.Review;
import com.main.dto.User;
import com.main.exceptions.WrongYearException;

import org.junit.Test;

public class ReviewTest {

    @Test
    public void reviewTest() {

        User user = new User("SRK");
        Movie movie ;
        try {
            movie = new Movie("Padamavat", 2001, "comedy");
        } catch (WrongYearException e) {
            movie = null;
        }
        Review review = new Review(user, movie, 50);

        assertEquals(review.getYear(), LocalDate.now().getYear());


    }
    
}
