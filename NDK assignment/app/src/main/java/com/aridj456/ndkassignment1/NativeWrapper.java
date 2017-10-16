package com.aridj456.ndkassignment1;


public class NativeWrapper {
    static {
        System.loadLibrary("MidPoint");
    }

    public native Point getMidPoint(Point a, Point b);

    public native int distance(Point a, Point b);
}