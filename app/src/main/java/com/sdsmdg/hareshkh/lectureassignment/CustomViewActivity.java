package com.sdsmdg.hareshkh.lectureassignment;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class CustomViewActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        final View view = findViewById(R.id.activity_custom_view);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ProgressRectangle progressRectangle = (ProgressRectangle) findViewById(R.id.progressRectangle);
                progressRectangle.draw(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar.make(view,"Hello!",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
