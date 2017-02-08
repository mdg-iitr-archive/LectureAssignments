package com.sdsmdg.hareshkh.lectureassignment;

/**
 * Created by Suyash on 31-01-2017.
 */

public class Movie {
    private String movieName;
    private String[] tags;
    private String ratings;

    public Movie(String movieName, String ratings, String[] tags) {
        this.movieName = movieName;
        this.ratings = ratings;
        this.tags = tags;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String generateStringFromTags(){
        String tagsToReturn = new String();
        for (int i = 0; i < tags.length - 1; i++){
            tagsToReturn += tags[i] + " | ";
        }

        tagsToReturn += tags[tags.length - 1];

        return tagsToReturn;
    }
}
