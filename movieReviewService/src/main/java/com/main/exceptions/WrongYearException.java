package com.main.exceptions;

public class WrongYearException extends Exception{
    
    public WrongYearException() {
        super("Wrong year provided");
    }
    public String toString() {
        return this.getMessage();

    }    

}

