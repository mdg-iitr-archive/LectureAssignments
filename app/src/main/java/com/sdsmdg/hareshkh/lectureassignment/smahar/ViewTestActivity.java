package com.sdsmdg.hareshkh.lectureassignment.smahar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;


import com.sdsmdg.hareshkh.lectureassignment.R;

public class ViewTestActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private CustomProgressBar customProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);

        seekBar = (SeekBar) findViewById(R.id.test_view_seek_bar);
        customProgressBar = (CustomProgressBar) findViewById(R.id.test_view_custom_progress_bar);

        seekBar.setMax(150);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                customProgressBar.setProgress(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(seekBar.getContext(), "This is a text", Toast.LENGTH_LONG).show();
            }
        });
    }
}
