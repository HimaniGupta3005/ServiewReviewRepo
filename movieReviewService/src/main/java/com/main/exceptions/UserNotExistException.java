package com.main.exceptions;

public class UserNotExistException extends Exception{

    public UserNotExistException() {
        super("User does not exist");
    }

    public String toString() {
        return this.getMessage();
    }
    
}
