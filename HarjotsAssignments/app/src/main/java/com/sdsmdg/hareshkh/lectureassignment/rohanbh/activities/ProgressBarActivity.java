package com.sdsmdg.hareshkh.lectureassignment.rohanbh.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.sdsmdg.hareshkh.lectureassignment.R;
import com.sdsmdg.hareshkh.lectureassignment.rohanbh.CustomProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        SeekBar seekBar = (SeekBar) findViewById(R.id.my_seekbar);
        final CustomProgressBar progressBar = (CustomProgressBar) findViewById(R.id.my_progress_bar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar.make(findViewById(R.id.my_c_layout), "Rohan", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
