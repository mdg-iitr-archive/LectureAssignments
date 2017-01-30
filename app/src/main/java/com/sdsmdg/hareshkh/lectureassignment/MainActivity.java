package com.sdsmdg.hareshkh.lectureassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;
    private MovieAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        movies = new ArrayList<Movie>();

        movies.add(new Movie("Kimi no Na Wa", 2016, R.drawable.kimi_no_na_wa));
        movies.add(new Movie("Kotonoha no Niwa", 2013, R.drawable.kotonoha_no_niwa));
        movies.add(new Movie("Summer Wars", 2009, R.drawable.summer_wars));
        movies.add(new Movie("Toki wo Kakeru Shoujo", 2006, R.drawable.toki_wo_kakeru_shoujo));
        movies.add(new Movie("Sen to Chihiro no Kamikakushi", 2001, R.drawable.sen_to_chihiro_no_kamikakushi));
        movies.add(new Movie("Tenkuu no Shiro Laputa", 1986, R.drawable.tenkuu_no_shiro_laputa));
        movies.add(new Movie("Majo no Takkyuubin", 1989, R.drawable.majo_no_takkyuubin));


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.movieList);
        mRecyclerView.setHasFixedSize(true);
        final LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new MovieAdapter(movies);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);


    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MovieAdapter) mAdapter).setOnItemClickListener(new MovieAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Toast msg = Toast.makeText(MainActivity.this, movies.get(position).getTitle() + " Clicked!", Toast.LENGTH_SHORT);
                msg.show();
            }
        });
    }
}
