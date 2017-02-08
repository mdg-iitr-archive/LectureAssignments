package com.sdsmdg.hareshkh.lectureassignment;

/**
 * Created by Mohit on 1/31/2017.
 */

public class Movie {

    private String mTitle;
    private int mYear, mImageResourceId;

    public Movie(String title, int year, int imageResourceId) {
        mTitle = title;
        mYear = year;
        mImageResourceId = imageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getYear() {
        return mYear;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
