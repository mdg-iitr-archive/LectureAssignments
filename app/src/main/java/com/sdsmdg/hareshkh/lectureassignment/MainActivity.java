package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private List<Movie> moviesList=new ArrayList<>();
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(moviesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

        private void prepareMovieData() {

           Movie movie = new Movie("Star Trek", "2009");
            moviesList.add(movie);

            movie = new Movie("The LEGO Movie", "2014");
            moviesList.add(movie);

            movie = new Movie("Iron Man", "2008");
            moviesList.add(movie);

            movie = new Movie("Aliens", "1986");
            moviesList.add(movie);

            movie = new Movie("Chicken Run", "2000");
            moviesList.add(movie);

            movie = new Movie("Back to the Future", "1985");
            moviesList.add(movie);

            movie = new Movie("Raiders of the Lost Ark","1981");
            moviesList.add(movie);

            movie = new Movie("Goldfinger", "1965");
            moviesList.add(movie);

            movie = new Movie("Guardians of the Galaxy", "2014");
            moviesList.add(movie);

            mAdapter.notifyDataSetChanged();
        }
}
