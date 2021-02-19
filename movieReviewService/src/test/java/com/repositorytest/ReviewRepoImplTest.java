package com.repositorytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.main.Repository.ReviewRepo;
import com.main.Repository.ReviewRepoImpl;
import com.main.dto.Movie;
import com.main.dto.Review;
import com.main.dto.User;
import com.main.exceptions.MovieNotReleasedException;
import com.main.exceptions.UserAlreadyAddedReviewForMovieException;

import org.junit.Test;
import org.mockito.Mock;

public class ReviewRepoImplTest {

    @Mock
    private Movie movie;

    @Test
    public void addReviewTest() {

        ReviewRepoImpl reviewRepoImpl = new ReviewRepoImpl();

        User user = new User("srk");
        Movie movie;
        List<String> list = new ArrayList<String>();
        list.add("comedy");

        try {
            movie = new Movie("padamavat", 2006, list);
        } catch (Exception e) {
            System.out.println(e);
            movie = null;
        }

        Review review = new Review(user, movie, 5);

        try {
            assertEquals(reviewRepoImpl.addReview(review), review);
        } catch (UserAlreadyAddedReviewForMovieException | MovieNotReleasedException e) {
            e.printStackTrace();
        }


        

    }

    @Test
    public void addReviewForFutureReleaseMovieTest() {

        ReviewRepoImpl reviewRepoImpl = new ReviewRepoImpl();

        User user = new User("srk");
        Movie movie;
        List<String> list = new ArrayList<String>();
        list.add("comedy");
        try {
            movie = new Movie("padamavat", 2106, list);
        } catch (Exception e) {
            System.out.println(e);
            movie = null;
        }

        Review review = new Review(user, movie, 5);

        try {
            assertEquals(reviewRepoImpl.addReview(review), review);
        } catch (UserAlreadyAddedReviewForMovieException e) {
            assertTrue(false);
        } catch( MovieNotReleasedException e) {
            assertEquals(true, true);
        }

    }

    @Test
    public void addReviewForUserMultipleTimeTest() {

        ReviewRepoImpl reviewRepoImpl = new ReviewRepoImpl();

        User user = new User("srk");
        Movie movie;
        List<String> list = new ArrayList<String>();
        list.add("comedy");

        try {
            movie = new Movie("padamavat", 2006, list);
        } catch (Exception e) {
            System.out.println(e);
            movie = null;
        }

        Review review = new Review(user, movie, 5);

        try {
            assertEquals(reviewRepoImpl.addReview(review), review);
        } catch (UserAlreadyAddedReviewForMovieException e) {
            assertTrue(true);
        } catch( MovieNotReleasedException e) {
            assertEquals(false, true);
        }


        try {
            assertEquals(reviewRepoImpl.addReview(review), review);
        } catch (UserAlreadyAddedReviewForMovieException e) {
            assertTrue(true);
        } catch( MovieNotReleasedException e) {
            assertEquals(false, true);
        }
    }

    @Test
    public void getReviewedMovieByUserTest() {

        ReviewRepo reviewRepoImpl = new ReviewRepoImpl();

        User user = new User("srk");
        Movie movie;
        List<String> list = new ArrayList<String>();
        list.add("comedy");
        try {
            movie = new Movie("padamavat", 2006, list);
        } catch (Exception e) {
            System.out.println(e);
            movie = null;
        }

        Review review = new Review(user, movie, 5);

        try {
            assertEquals(reviewRepoImpl.addReview(review), review);
        } catch (UserAlreadyAddedReviewForMovieException e) {
            
        } catch( MovieNotReleasedException e) {
            
        }

        Movie movie1;

        try {
            movie1 = new Movie("lunchbox", 2007, list);
        } catch (Exception e) {
            System.out.println(e);
            movie1 = null;
        }

        Review review1 = new Review(user, movie1, 5);

        try {
            assertEquals(reviewRepoImpl.addReview(review1), review1);
        } catch (UserAlreadyAddedReviewForMovieException e) {
            
        } catch( MovieNotReleasedException e) {
            
        }

        assertEquals(reviewRepoImpl.getReviewedMovieByUser(user, "comedy").get(0), movie);
        assertEquals(reviewRepoImpl.getReviewedMovieByUser(user, "comedy").get(1), movie1);


    }




}
