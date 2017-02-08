package com.sdsmdg.hareshkh.lectureassignment.activities;

import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.sdsmdg.hareshkh.lectureassignment.R;

public class CoordinatorLayoutActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressBar.setProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar.make(seekBar,"Use seekbar to increase or decrease",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
