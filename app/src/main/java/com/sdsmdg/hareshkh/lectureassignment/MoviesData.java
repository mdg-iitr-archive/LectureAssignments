package com.sdsmdg.hareshkh.lectureassignment;

/**
 * Created by samagra on 01-02-2017.
 */

public class MoviesData {
    private String title,year;
    private int imageResource;
    public MoviesData() {
    }
    public MoviesData(String title, int imageResource, String year) {
        this.title = title;
        this.imageResource = imageResource;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public int getImageResource() {
        return imageResource;
    }
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
