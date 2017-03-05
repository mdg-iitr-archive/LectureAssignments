package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MoviesData> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareMovieData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MoviesData movie = movieList.get(position);
                if (position == 0){
                    Intent intent = new Intent(MainActivity.this,AssignmentSecond.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(MainActivity.this,MusicPlayerInterface.class);
                    startActivity(intent);
                }
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


    }

    private void prepareMovieData() {
        MoviesData movie = new MoviesData("Assignment 2 ", R.drawable.s03_ep01, "Dependencies");
        movieList.add(movie);

        movie = new MoviesData("Assignment 3", R.drawable.s03_ep01, "Music Player App");
        movieList.add(movie);

        movie = new MoviesData("Star Wars: Episode VII - The Force Awakens", R.drawable.s03_ep01, "2015");
        movieList.add(movie);

        movie = new MoviesData("Shaun the Sheep", R.drawable.s03_ep01, "2015");
        movieList.add(movie);

        movie = new MoviesData("The Martian", R.drawable.s03_ep01, "2015");
        movieList.add(movie);

        movie = new MoviesData("Mission: Impossible Rogue Nation", R.drawable.s03_ep01, "2015");
        movieList.add(movie);

        movie = new MoviesData("Up", R.drawable.s03_ep01, "2009");
        movieList.add(movie);

        movie = new MoviesData("Star Trek", R.drawable.s03_ep01, "2009");
        movieList.add(movie);

        movie = new MoviesData("The LEGO Movie", R.drawable.s03_ep01, "2014");
        movieList.add(movie);

        movie = new MoviesData("Iron Man", R.drawable.s03_ep01, "2008");
        movieList.add(movie);

        movie = new MoviesData("Aliens", R.drawable.s03_ep01, "1986");
        movieList.add(movie);

        movie = new MoviesData("Chicken Run", R.drawable.s03_ep01, "2000");
        movieList.add(movie);

        movie = new MoviesData("Back to the Future", R.drawable.s03_ep01, "1985");
        movieList.add(movie);

        movie = new MoviesData("Raiders of the Lost Ark", R.drawable.s03_ep01, "1981");
        movieList.add(movie);

        movie = new MoviesData("Goldfinger", R.drawable.s03_ep01, "1965");
        movieList.add(movie);

        movie = new MoviesData("Guardians of the Galaxy", R.drawable.s03_ep01, "2014");
        movieList.add(movie);


    }
}
