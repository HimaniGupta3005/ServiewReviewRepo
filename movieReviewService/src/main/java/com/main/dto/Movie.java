package com.main.dto;

import java.time.Year;
import java.util.*;
import java.util.Map.Entry;

import com.main.exceptions.WrongYearException;

public class Movie {

    private String movieName;
    private int release;
    private List<String> genre;
    public int totalReview;
    private Map<Integer, Integer> scoreMap;
    private Map<Integer, Integer> yearMap;

    public Movie(String movieName2, int year, List<String> genre2) throws WrongYearException {

        this.movieName = movieName2;
        if (year < 1500 || year > 9999)
            throw new WrongYearException();
        this.release = year;
        genre = new ArrayList<String>();
        for(String s:genre2) {
            genre.add(s.toUpperCase());
        }
    
        this.totalReview = 0;
        scoreMap = new HashMap<Integer, Integer>();
        yearMap = new HashMap<Integer, Integer>();
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {

        for(String s:genre) {
            genre.add(s.toUpperCase());
        }
        
    }

    public void setScore(int year, int totalScore) {

       if (scoreMap.containsKey(year)) {
            int value = scoreMap.get(year);
            int count = yearMap.get(year);

            value += totalScore;
            scoreMap.put(year, value);
            yearMap.put(year, count+1);
        } else {
            scoreMap.put(year, totalScore);
            yearMap.put(year, 1);
        }

        (this.totalReview)++;
    }

    public int getScore() {

        int score = 0;

        for(Map.Entry<Integer,Integer> m : scoreMap.entrySet()){
            score +=  m.getValue();
        }
        if (totalReview == 0) 
            return 0;
        return score/totalReview;
    }
    public int getAverageScore(int year) {

        if(scoreMap.containsKey(year))
            return scoreMap.get(year)/yearMap.get(year);
        return 0;

    }

    public int getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(int totalReview) {
        this.totalReview = totalReview;
    }


}