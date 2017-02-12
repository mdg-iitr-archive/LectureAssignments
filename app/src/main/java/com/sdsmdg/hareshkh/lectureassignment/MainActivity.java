package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MoviesModel> listOfMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listOfMoviesRecyclerView = (RecyclerView) findViewById(R.id.listOfMovies);
        listOfMovies.add(0,new MoviesModel(R.drawable.the_secret_life_of_pets,"The Secret Life of Pets", "18-06-2016"));
        listOfMovies.add(1,new MoviesModel(R.drawable.suicide_squad,"Suicide Squad", "02-08-2016"));
        listOfMovies.add(2,new MoviesModel(R.drawable.la_la_land,"La La Land", "01-12-2016"));
        listOfMovies.add(3,new MoviesModel(R.drawable.assassins_creed,"Assassin's Creed","21-12-2016"));
        listOfMovies.add(4,new MoviesModel(R.drawable.finding_dory,"Finding Dory","16-06-2016"));
        listOfMovies.add(5,new MoviesModel(R.drawable.jurassic_world,"Jurassic World","09-06-2015"));
        listOfMovies.add(6,new MoviesModel(R.drawable.moana,"Moana","23-11-2016"));
        listOfMovies.add(7,new MoviesModel(R.drawable.interstellar,"Interstellar","05-11-2014"));
        listOfMovies.add(8,new MoviesModel(R.drawable.captain_america_civil_war,"Captain America: Civil War","27-04-2016"));
        listOfMovies.add(9,new MoviesModel(R.drawable.mad_max_fury_road,"Mad Max:Fury Road","13-05-2015"));
        listOfMovies.add(10,new MoviesModel(R.drawable.arrival,"Arrival","10-11-2016"));
        listOfMovies.add(11,new MoviesModel(R.drawable.passengers,"Passengers","21-12-2016"));
        listOfMovies.add(12,new MoviesModel(R.drawable.inferno,"Inferno","13-10-2016"));
        listOfMovies.add(13,new MoviesModel(R.drawable.the_magnificient_seven,"The Magnificient Seven","14-09-2016"));
        listOfMovies.add(14,new MoviesModel(R.drawable.split,"Split","19-01-2017"));

        Adapter adapter = new Adapter(this,listOfMovies);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        listOfMoviesRecyclerView.setAdapter(adapter);
        listOfMoviesRecyclerView.setHasFixedSize(true);
        listOfMoviesRecyclerView.setLayoutManager(linearLayout);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButtonToCustomActivity);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomViewActivity.class);
                startActivity(intent);
            }
        });
    }


}
