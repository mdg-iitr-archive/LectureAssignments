package com.sdsmdg.hareshkh.lectureassignment;

/**
 * Created by Jaskirat on 03-02-2017.
 */

public class Movie
{
    private String name;
    private String year;
    private String genre;
    private int img;

    public Movie()
    {
    }

    public Movie(String name, String year, String genre, int img)
    {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.img = img;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setImg(int img)
    {
        this.img = img;
    }

    public int getImg()
    {
        return img;
    }

}
