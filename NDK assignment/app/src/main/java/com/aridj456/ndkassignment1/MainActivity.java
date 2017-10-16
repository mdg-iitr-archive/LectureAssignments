package com.aridj456.ndkassignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("MidPoint");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Point a = new Point(200,200);
        Point b = new Point(800,800);
        Graph view = new Graph(this,a,b);
        setContentView(view);
    }
}
