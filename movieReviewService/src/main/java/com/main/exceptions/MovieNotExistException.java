package com.main.exceptions;

public class MovieNotExistException extends Exception{
    
    public MovieNotExistException() {
        super("Movie does not exist");
    }


    public String toString() {
        return this.getMessage();
    }

}
