package com.sdsmdg.hareshkh.lectureassignment;

public class movies {

    String title;
    String year;
    String imageResId;

    public movies(String title, String year, String imageResId) {
        this.title = title;
        this.year = year;
        this.imageResId = imageResId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageResId() {
        return imageResId;
    }

    public void setImageResId(String imageResId) {
        this.imageResId = imageResId;
    }
}
