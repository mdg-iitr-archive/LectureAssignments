package com.sdsmdg.hareshkh.lectureassignment.Model;

/**
 * Created by Arihant Jain on 1/30/2017.
 */

public class MovieModel {
    private String name;
    private String year;
    private int imageId;

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public MovieModel(String name, String year, int imageId) {
        this.name = name;
        this.year = year;
        this.imageId = imageId;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
