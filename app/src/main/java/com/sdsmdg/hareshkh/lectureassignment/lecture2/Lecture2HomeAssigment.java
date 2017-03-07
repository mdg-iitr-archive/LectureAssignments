package com.sdsmdg.hareshkh.lectureassignment.lecture2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.sdsmdg.hareshkh.lectureassignment.R;

public class Lecture2HomeAssigment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout_home_assignment);

        ProgressBar p = (ProgressBar) findViewById(R.id.progressBar);
        SeekBar s = (SeekBar) findViewById(R.id.seek_bar);

    }
}
