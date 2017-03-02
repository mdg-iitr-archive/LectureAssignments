package com.sdsmdg.hareshkh.lectureassignment;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import static com.sdsmdg.hareshkh.lectureassignment.R.id.coordinator_layout;
import static com.sdsmdg.hareshkh.lectureassignment.R.id.seekbar;

public class AssignmentSecond extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_second);



        //identifying various views
        SeekBar seekbar = (SeekBar) findViewById(R.id.seekbar);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);

        /**
         * seekbar setup
         */
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(AssignmentSecond.this, "seekbar touch started", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Snackbar.make(findViewById(R.id.coordinator_layout),"Seekbar touch stopped",Snackbar.LENGTH_INDEFINITE).show();

            }


        });

        /**
         * progressbar setup
         */

        AsiignmentTwoBehaviour behaviour = new AsiignmentTwoBehaviour();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) relativeLayout.getLayoutParams();
        params.setBehavior(behaviour);

    }
}
