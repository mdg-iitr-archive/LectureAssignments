package com.sdsmdg.hareshkh.lectureassignment;

/**
 * Created by shyam on 31-Jan-17.
 */

public class MoviesModel{
    int moviePoster;
    String movieName;
    String movieReleaseDate;

    MoviesModel(int moviePoster, String movieName, String movieReleaseDate){
        this.movieName = movieName;
        this.movieReleaseDate = movieReleaseDate;
        this.moviePoster = moviePoster;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public int getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(int moviePoster) {
        this.moviePoster = moviePoster;
    }
}
