package com.sdsmdg.hareshkh.lectureassignment.lecture3.onSpotTask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sdsmdg.hareshkh.lectureassignment.R;

/**
 * Created by root on 1/3/17.
 */

public class onSpotClass extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_spot_task_layout);
    }

    public void playSong(View view){
        Intent i = new Intent(this, MyService.class);
        i.putExtra("url", "http://dot.890m.com/shapeofyou.mp3");
        startService(i);
    }
}
