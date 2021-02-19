package com.factorytest;

import static org.junit.Assert.assertEquals;

import com.main.Repository.MovieRepo;
import com.main.factories.MovieRepoFactory;

import org.junit.Test;

public class MovieRepoFactoryTest {

    @Test
    public void sameObjectToBeReturnedWhenCalledMultipleTimesTest() {

       MovieRepoFactory factory = new MovieRepoFactory();
       
       MovieRepo movieRepo = factory.getMovieRepo();
       
       assertEquals(movieRepo, factory.getMovieRepo());
    }
    
}
