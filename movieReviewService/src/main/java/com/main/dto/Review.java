package com.main.dto;

import java.time.LocalDate;
import java.time.Year;

public class Review {

    private Movie movie;
    private User user;
    private int points;
    private int year;

    public Review(User user2, Movie movie, int points) {
        this.user= user2;
        this.movie = movie;
        this.points = points;
        year = LocalDate.now().getYear();
	}

	public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getYear() {
        return year;
    }


    
}
