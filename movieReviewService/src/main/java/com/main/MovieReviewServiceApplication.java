package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import com.main.dto.Movie;
import com.main.dto.User;
import com.main.exceptions.InvalidScoreException;
import com.main.exceptions.MovieNotExistException;
import com.main.exceptions.MovieNotReleasedException;
import com.main.exceptions.UserAlreadyAddedReviewForMovieException;
import com.main.exceptions.UserNotExistException;
import com.main.exceptions.WrongYearException;
import com.main.controller.ReviewController;

public class MovieReviewServiceApplication {

    public static void main(String str[]) {

        Scanner sn = new Scanner(System.in);
        ReviewController service = new ReviewController();
        int n;

        do {
            System.out.println("Choose one of below options");
            System.out.println("1. Add new user");
            System.out.println("2. Add new movie");
            System.out.println("3. Give review of a movie");
            System.out.println("4. Get all Users");
            System.out.println("5. Get average score for a movie");
            System.out.println("6. check all review made by user");
            System.out.println("7. Get avaerage score for a movie in a particular year");
            System.out.println("8. exit");

            n = sn.nextInt();
            sn.nextLine();
            switch (n) {

                case 1:
                    System.out.println("Enter User name");
                    String name = sn.nextLine();
                    
                    service.addUser(name);
                    break;

                case 2:
                    System.out.println("Enter Movie name");
                    String mname = sn.nextLine();
                    System.out.println("Enter release year");
                    int year = sn.nextInt();
                    System.out.println("Enter number of genres movie have");
                    int count = sn.nextInt();
                    sn.nextLine();
                    

                    System.out.println("Enter genre");
                    String genre = sn.nextLine();

                    List<String> genreList = new ArrayList<String>();
                    genreList.add(genre);
                    for(int i=2;i<=count;i++) {
                        System.out.println("Enter next genre");
                        genre = sn.nextLine();
                        genreList.add(genre);
                    }
                    try {
                        service.addMovie(mname, year, genreList);
                    } catch (WrongYearException e) {
                        System.out.println(e + " Movie not added");
                        //System.exit(0);
                    }
                    break;

                case 3:
                    System.out.println("Enter Movie Name");
                    String m = sn.nextLine();
                    System.out.println("Enter User Name");
                    String uname = sn.nextLine();
                    System.out.println("Enter score");
                    int score = sn.nextInt();
                    sn.nextLine();
                    try {
                        service.giveReview(uname, m, score);
                    } catch (UserAlreadyAddedReviewForMovieException e2) {
                        System.out.println(e2);
                    } catch (MovieNotReleasedException e2) {
                        System.out.println(e2);
                    } catch (UserNotExistException e2) {
                        System.out.println(e2);
                    } catch (MovieNotExistException e2) {
                        System.out.println(e2);
                    } catch(InvalidScoreException e2) {
                        System.out.println(e2);
                    }
                    
                    break;

                case 4 :
                    List<User> list = service.getAllUser();
                    if(!list.isEmpty()) {

                        for(User u : list) {
                            System.out.println(""+u.getName());
                        }
                    }   else {
                        System.out.println("No user to show");
                    }
                    break;
                case 5 :
                    System.out.println("Enter movie name");
                    String mn = sn.nextLine();
                    try {
                        System.out.println(service.getScore(mn));
                    } catch (MovieNotExistException e1) {
                        System.out.println(e1);
                        //System.exit(0);
                    }
                    break;
                case 6 :
                    System.out.println("Enter usr name ");
                    String nmm = sn.nextLine();
                    System.out.println("Enter genre");
                    String st = sn.nextLine();
                    List<Movie> movieList;
                    try {
                        movieList = service.getMovieByGenre(st, nmm);

                        if(movieList != null && !movieList.isEmpty()) {
                            for(Movie mt : movieList) {
                                System.out.println("movie name "+ mt.getMovieName());
                            }
                        }
                        else {
                            System.out.println("No movie reviewed by "+nmm+" of genre "+st);
                        }
                    } catch (UserNotExistException e) {
                        System.out.println(e);
                        //System.exit(0);
                    }

                    
                    break;
                
                case 7 :
                    System.out.println("Enter Movie name ");
                    String movie1 = sn.nextLine();
                    System.out.println("Enter year");
                    int year1 = sn.nextInt();
                    sn.nextLine();

                    System.out.println(service.getMovieScoreByYear(movie1,year1));
                    
                    break;

                default :
                    if(n != 8)
                        System.out.println(n+" is not valid options. Please enter no. between 1-8");
            }


        }while(n != 8);
        
        System.out.println("Thanks");

    }

    
}
