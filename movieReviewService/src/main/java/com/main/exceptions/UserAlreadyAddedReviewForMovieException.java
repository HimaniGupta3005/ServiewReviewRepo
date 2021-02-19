package com.main.exceptions;

public class UserAlreadyAddedReviewForMovieException extends Exception{


    public UserAlreadyAddedReviewForMovieException() {
        super("User Already added review for provided Movie");
    }
    public String toString() {
        return this.getMessage();
    }
    
}
