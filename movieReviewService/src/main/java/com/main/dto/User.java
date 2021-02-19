package com.main.dto;
import java.util.*;

public class User {

    private String name;
    private int year;
    private String title;

    public User(String name) {
        this.name = name;
        title = "Viewer";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}