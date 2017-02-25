package com.sdsmdg.hareshkh.lectureassignment.aniket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.sdsmdg.hareshkh.lectureassignment.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MovieItems> mov = new ArrayList<>();
        mov.add(new MovieItems("Resident Evil Final Chapter", "Feb 3 2017", R.drawable.m1));
        mov.add(new MovieItems("Assassin's Creed", "Dec 30 2016", R.drawable.asscreed));
        mov.add(new MovieItems("Bye Bye Man", "Jan 20 2017", R.drawable.byebyeman));
        mov.add(new MovieItems("Moana", "Dec 2 2016", R.drawable.moana));
        mov.add(new MovieItems("Passengers", "Jan 6 2017", R.drawable.passengers));
        mov.add(new MovieItems("The Great Wall", "Feb 3 2017", R.drawable.thegreatwall));
        mov.add(new MovieItems("XXX : The Return of Xander Cage", "Jan 14 2017", R.drawable.xxxretofxandercage));
        mov.add(new MovieItems("Arrival", "Feb 3 2017", R.drawable.arrival));
        ArrayAdapter adapter = new ArrayAdapter(mov);
        RecyclerView recylView = (RecyclerView) findViewById(R.id.recyl);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recylView.setLayoutManager(horizontalLayoutManagaer);
        recylView.setAdapter(adapter);
        Button asgn = (Button) findViewById(R.id.asgn2);
        asgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SeekBarActivity.class);
                startActivity(i);

            }
        });
    }
}
