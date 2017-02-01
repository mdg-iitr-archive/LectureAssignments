package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.sdsmdg.hareshkh.lectureassignment.adapter.MovieAdapter;
import com.sdsmdg.hareshkh.lectureassignment.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        movieAdapter = new MovieAdapter(movieList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);

        fillAdapter();
    }

    private void fillAdapter(){

        Movie m = new Movie("1st Movie", R.drawable._1, 1997);
        movieList.add(m);

        m = new Movie("2nd Movie", R.drawable._5, 1998);
        movieList.add(m);

        m = new Movie("3rd Movie", R.drawable._3, 1997);
        movieList.add(m);

        m = new Movie("4th Movie", R.drawable._4, 1997);
        movieList.add(m);

        m = new Movie("5th Movie", R.drawable._5, 1997);
        movieList.add(m);

        m = new Movie("6th Movie", R.drawable._1, 1997);
        movieList.add(m);

        m = new Movie("7th Movie", R.drawable._3, 1997);
        movieList.add(m);

        m = new Movie("8th Movie", R.drawable._4, 1997);
        movieList.add(m);

        m = new Movie("8th Movie", R.drawable._1, 1997);
        movieList.add(m);

        m = new Movie("9th Movie", R.drawable._5, 1997);
        movieList.add(m);

        m = new Movie("10th movie", R.drawable._3, 1997);
        movieList.add(m);

        movieAdapter.notifyDataSetChanged();
    }

}
