package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    List<Movie> movieList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView cycle=(RecyclerView) findViewById(R.id.recycle);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        cycle.setLayoutManager(layoutManager);

        Movie e=new Movie("The Shawshank Redemption","1994","Thriller",R.drawable.shawshank);
        Movie f=new Movie("The Pursuit of Happyness","2006","Biography",R.drawable.happyness);
        Movie b=new Movie("Fifty Shades of Grey","2011","Romance",R.drawable.grey);
        Movie g=new Movie("Titanic","1997","Drama/Disaster",R.drawable.titanic);
        Movie a=new Movie("The Wolf of Wall Street","2013","Biography",R.drawable.wolf);
        Movie c=new Movie("The Dictator","2012","Comedy",R.drawable.dictator);
        Movie d=new Movie("The Godfather","1972","Drama",R.drawable.godfather);
        Movie h=new Movie("The Dark Knight","2008","Crime",R.drawable.joker);
        Movie i=new Movie("La La Land","2016","Romance",R.drawable.lala);

        movieList.add(a);
        movieList.add(b);
        movieList.add(c);
        movieList.add(d);
        movieList.add(e);
        movieList.add(f);
        movieList.add(g);
        movieList.add(h);
        movieList.add(i);

        MovieAdapter movieAdapter=new MovieAdapter(this,movieList);
        cycle.setAdapter(movieAdapter);
    }
}
