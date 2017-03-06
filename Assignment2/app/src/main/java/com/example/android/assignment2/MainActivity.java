package com.example.android.assignment2;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;


public class MainActivity extends AppCompatActivity{

    com.example.android.assignment2.ProgressBar mprogressBar;
    SeekBar seekBar;
    Snackbar bar;
    CoordinatorLayout coordinatorLayout;
    RelativeLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mprogressBar=(com.example.android.assignment2.ProgressBar) findViewById(R.id.custom_progress_bar);
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.activity_main);
        appBarLayout=(RelativeLayout)findViewById(R.id.appbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mprogressBar.setProgress((int)((seekBar.getProgress()/(float)seekBar.getMax())*100));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                bar = Snackbar.make(coordinatorLayout, "Hello", Snackbar.LENGTH_LONG);
                bar.show();
            }
        });
    }
}
