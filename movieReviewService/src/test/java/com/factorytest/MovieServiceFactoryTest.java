package com.factorytest;

import static org.junit.Assert.assertEquals;

import com.main.factories.MovieServiceFactory;
import com.main.services.MovieService;

import org.junit.Test;

public class MovieServiceFactoryTest {
 
    @Test
    public void sameObjectToBeReturnedWhenCalledMultipleTimesTest() {

       MovieServiceFactory factory = new MovieServiceFactory();
       
       MovieService movieService = factory.getMovieService();
       
       assertEquals(movieService, factory.getMovieService());
    }
}
