package com.main.exceptions;

public class InvalidScoreException extends Exception{

    public InvalidScoreException() {
        super("Score out of valid range");
    }
    
    public String toString() {
        return this.getMessage();
    }
}
