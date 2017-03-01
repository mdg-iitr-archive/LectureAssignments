package com.sdsmdg.hareshkh.lectureassignment.kriti;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sdsmdg.hareshkh.lectureassignment.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String movie_names[] = {
            "Civil War: Captain America",
            "Divergent",
            "Gravity",
            "Insurgent",
            "The Martian",
            "The Maze Runner",
            "Pursuit of Happiness",
            "Revenant",
            "Titanic",
            "Transformers",
            "Twilight",
            "Fast and Furious",
            "Jurassic Park",
            "Deathly Hallows"
    };

    private final String movie_year[] = {
            "2016",
            "2014",
            "2013",
            "2015",
            "2015",
            "2014",
            "2006",
            "2015",
            "1997",
            "2007",
            "2008",
            "2009",
            "1993",
            "2010"
    };

    private final int image_location[] = {
        R.drawable.civilwar, R.drawable.divergent, R.drawable.gravity, R.drawable.insurgent, R.drawable.martian, R.drawable.mazerunner, R.drawable.poh, R.drawable.revenant, R.drawable.titanic, R.drawable.transformers, R.drawable.twilight, R.drawable.faf, R.drawable.jurassic,R.drawable.hp

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareData(){

        ArrayList movie_list = new ArrayList<>();
        for(int i=0;i<movie_names.length;i++){
            Movie movie = new Movie();
            movie.setMovie_name(movie_names[i]);
            movie.setMovie_year(movie_year[i]);
            movie.setImage_location(image_location[i]);
            movie_list.add(movie);
        }
        return movie_list;
    }

}
