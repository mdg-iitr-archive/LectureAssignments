package com.sdsmdg.hareshkh.lectureassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickListener{

    RecyclerView recyclerView;
    List<Movie> movieList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.movie_list);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Movie a=new Movie(R.drawable.image1_opt,"La La Land","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image2_opt,"Manchester By The Sea","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image3_opt,"Moonlight","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image4_opt,"Arrival","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image5_opt,"Hell Or High Water","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image6_opt,"Deadpool","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image7_opt,"Rogue One","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image8_opt,"Captain America","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image9_opt,"Zootopia","2016");
        movieList.add(a);
        a=new Movie(R.drawable.image10_opt,"The Handmaiden","2016");
        movieList.add(a);

        MovieAdapter movieAdapter=new MovieAdapter(this,movieList);
        movieAdapter.setClickListener(this);
        recyclerView.setAdapter(movieAdapter);


    }

    @Override
    public void itemClicked(View view, int position) {
        TextView title=(TextView)view.findViewById(R.id.title);
        TextView year=(TextView)view.findViewById(R.id.year);
        String str_title=title.getText().toString();
        String str_year=year.getText().toString();
        Toast.makeText(this, str_title+" "+str_year , Toast.LENGTH_SHORT).show();
    }
}
