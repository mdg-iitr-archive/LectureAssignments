package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movies = new ArrayList<Movie>();
    private RecyclerView moviesRecyclerView;
    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView moviesRecyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        mAdapter = new MovieAdapter(this.movies);
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getApplicationContext());
        moviesRecyclerView.setLayoutManager(lManager);
        moviesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        moviesRecyclerView.setAdapter(mAdapter);

        populateListAndUpdate();
    }

    public void populateListAndUpdate(){
        String tagArr[] =  {"2016", "Sample", "No data"};

        for (int i = 0; i < 10; i++){
            movies.add(new Movie("Sample Movie " + i, "1.3" , tagArr));
        }

        mAdapter.notifyDataSetChanged();
    }
}
