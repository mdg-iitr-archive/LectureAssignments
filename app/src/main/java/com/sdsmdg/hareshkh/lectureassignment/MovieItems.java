package com.sdsmdg.hareshkh.lectureassignment;

/**
 * Created by DELL on 01-02-2017.
 */

public class MovieItems {
    public String moviename;
    public String movieyear;
    public int imageid;

    public MovieItems(String moviename, String movieyear, int imageid) {
        this.moviename = moviename;
        this.movieyear = movieyear;
        this.imageid = imageid;


    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMovieyear() {
        return movieyear;
    }

    public void setMovieyear(String movieyear) {
        this.movieyear = movieyear;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
