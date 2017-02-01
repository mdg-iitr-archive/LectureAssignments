package com.sdsmdg.hareshkh.lectureassignment.model;


public class Movie {

    private String name;
    private int poster;
    private int year;

    public Movie() {
    }

    public Movie(int year, String name) {
        this.year = year;
        this.name = name;
    }

    public Movie(String name, int poster, int year) {
        this.name = name;
        this.poster = poster;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
