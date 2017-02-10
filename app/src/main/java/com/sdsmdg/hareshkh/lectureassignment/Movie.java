package com.sdsmdg.hareshkh.lectureassignment;

/**
 * Created by Harshit Bansal on 1/31/2017.
 */

public class Movie {
    int image;
    String title;
    String year;

    public Movie(int image,String title,String year){
        this.image=image;
        this.title=title;
        this.year=year;
    }

    public int getImageId(){
        return image;
    }
    public String getTitle(){
        return title;
    }
    public String getYear(){
        return year;
    }
}
