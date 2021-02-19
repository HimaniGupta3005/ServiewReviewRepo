package com.main.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.main.dto.Movie;
import com.main.dto.Review;
import com.main.dto.User;
import com.main.exceptions.MovieNotReleasedException;
import com.main.exceptions.UserAlreadyAddedReviewForMovieException;
import com.main.factories.UserRepoFactory;
import com.main.services.ReviewService;

public class ReviewRepoImpl implements ReviewRepo {

    private List<Review> reviewList;
    private UserRepo userRepo;
    private UserRepoFactory factory;

    public ReviewRepoImpl() {
        reviewList = new ArrayList<Review>();
        factory = new UserRepoFactory();
        userRepo = factory.getUserRepo();

    }

    @Override
    public Review addReview(Review review) throws UserAlreadyAddedReviewForMovieException,MovieNotReleasedException {

        User user = review.getUser();
        Movie movie = review.getMovie();
        LocalDate localDate = LocalDate.now();
        int count = 0;

        if (movie.getRelease() > localDate.getYear()) {
            throw new MovieNotReleasedException();
        }

        
        for(Review r : reviewList) {
            if(r.getMovie() == movie && r.getUser() == user) {
                throw new UserAlreadyAddedReviewForMovieException();
            }
            if (r.getUser() == user) {
                count++;
            }
        }
        
        if(user.getTitle().equalsIgnoreCase("Viewer")) {
            int tmp2 = review.getPoints();
            movie.setScore(review.getYear(),tmp2);
        } else {
            int tmp2 = review.getPoints();
            movie.setScore(review.getYear(),tmp2 * 2);
        }
            
        if (count == 2) {
            userRepo.updateTitleToCritic(user);
            System.out.println(user.getName()+" has become Critic now!!");
            user.setYear(LocalDate.now().getYear());
        }

        reviewList.add(review);
        return review;
    }

    @Override
    public List<Movie> getReviewedMovieByUser(User user,String genre) {
        
        List<Movie> movieList = new ArrayList<Movie>();

        for(Review r : reviewList) {
            if(r.getUser() == user && r.getMovie().getGenre().contains(genre.toUpperCase()))
            movieList.add(r.getMovie());
        }

        if (movieList.isEmpty())
            return movieList;
        Collections.sort(movieList, new Comparator<Movie>(){

            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getScore() - o2.getScore();
            }
            
        });    
        return movieList;
    }

    
    
}
