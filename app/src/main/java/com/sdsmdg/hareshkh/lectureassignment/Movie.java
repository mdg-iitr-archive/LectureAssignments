package com.sdsmdg.hareshkh.lectureassignment;


public class Movie
{
    private String name, year;
    public Movie(){};
    public Movie(String name, String year)
    {
        this.name=name;
        this.year=year;
    }
    public String getName()
    {
        return name;
    }
    public String getYear()
    {
        return year;
    }
    public void setName(String name)
    {
        this.name=name;

    }
    public void setYear(String year)
    {
        this.year=year;
    }

}
