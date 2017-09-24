package com.sdsmdg.ndkassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'MidPoint' library on application startup.
    static {
        System.loadLibrary("MidPoint");
    }

    private static final String LOG_TAG = "MainActivity/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call to native method declared in Point
        Point p1 = new Point(5, 10);
        Point p2 = new Point(0, 2);

        Point midPoint = p1.getMidPoint(p1, p2);

        Log.v(LOG_TAG+"p1", p1.toString());
        Log.v(LOG_TAG+"p2", p2.toString());
        Log.v(LOG_TAG+"midP", midPoint.toString());

    }

}
