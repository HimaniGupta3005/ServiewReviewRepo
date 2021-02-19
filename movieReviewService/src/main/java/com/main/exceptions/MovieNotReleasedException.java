package com.main.exceptions;

public class MovieNotReleasedException extends Exception{

    public MovieNotReleasedException() {
        super("Movie not released yet");
    }

    public String toString() {
        return this.getMessage();
    }
}

