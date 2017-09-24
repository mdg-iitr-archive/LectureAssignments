package com.example.whocares.ndkassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("MidPoint");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Point p1 = new Point(100, 200);
        Point p2 = new Point(50, 100);
        Point midPoint = getMidPoint(p1, p2);

        Log.v("Midpoint", "The x coordinate of midpoint is" + midPoint.getX());
        Log.v("Midpoint", "The y coordinate of midpoint is" + midPoint.y);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native Point getMidPoint(Point p1, Point p2);
}
