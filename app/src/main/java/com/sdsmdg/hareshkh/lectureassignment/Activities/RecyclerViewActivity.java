package com.sdsmdg.hareshkh.lectureassignment.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.hareshkh.lectureassignment.Model.MovieModel;
import com.sdsmdg.hareshkh.lectureassignment.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private RecyclerViewAdapter adapter;
    private List<MovieModel> movieModels;
    private String[] movieNames = {
            "La La Land",
            "Moonlight",
            "Manchester by the Sea",
            "Arrival",
            "Hell or High Water",
            "Deadpool",
            "Captain America : Civil Wars",
            "Zootopia",
            "Rogue One",
            "Suicide Squad"
    };
    private int[] movieImages = {
            R.drawable.la_la_land,
            R.drawable.moonlight,
            R.drawable.manchester,
            R.drawable.arrival,
            R.drawable.hell,
            R.drawable.deadpool,
            R.drawable.civil_wars,
            R.drawable.zootopia,
            R.drawable.rogue_one,
            R.drawable.suicide
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
       // manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //data
        movieModels = new ArrayList<>();
        for(int i=0;i<movieNames.length;i++){
            movieModels.add(new MovieModel(movieNames[i],"2016",movieImages[i]));
        }
        adapter = new RecyclerViewAdapter(movieModels,this);
        recyclerView.setAdapter(adapter);
    }
}
