package com.sdsmdg.hareshkh.lectureassignment.lecture2;

import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.getbase.floatingactionbutton.AddFloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.sdsmdg.hareshkh.lectureassignment.R;

public class CoordinatorLayoutSample extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout_sample);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        FloatingActionButton fab;// = new FloatingActionButton(getApplicationContext())

//        drawShape shape = new drawShape(this);
//        setContentView(shape);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Hello", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}