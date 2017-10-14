package com.sdsmdg.ndkassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        //System.loadLibrary("native-lib");
        System.loadLibrary("Midpoint");
    }
    int a = 5, b = 3, c= 7, d = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        Point one = new Point(a,b);
        Point two = new Point(c,d);

        Point midPoint = getMidpoint(one,two);
        Log.e("Midpoint","x= "+ midPoint.getX()+" y= "+midPoint.y);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native Point getMidpoint(Point one, Point two);
}
