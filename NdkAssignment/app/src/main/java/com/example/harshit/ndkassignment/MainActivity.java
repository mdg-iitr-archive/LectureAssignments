package com.example.harshit.ndkassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("MidPoint");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        Point x = new Point(2, 8);
        Point y = new Point(4, 6);
        Log.i("MidPointX", Integer.toString(getMidPoint(x, y).getX()));
        Log.i("MidPointY", Integer.toString(getMidPoint(x, y).y));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native Point getMidPoint(Point x, Point y);
}
