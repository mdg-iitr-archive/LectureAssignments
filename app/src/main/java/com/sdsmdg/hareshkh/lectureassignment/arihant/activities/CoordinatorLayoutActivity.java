package com.sdsmdg.hareshkh.lectureassignment.arihant.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.hareshkh.lectureassignment.arihant.customviews.CustomProgressBar;

public class CoordinatorLayoutActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private CustomProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        progressBar = (CustomProgressBar) findViewById(R.id.progress);
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
                Snackbar.make(seekBar,"created by AeroMaster",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
