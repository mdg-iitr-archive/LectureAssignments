package com.sdsmdg.ndkassignment;

public class Point {

    private int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public native Point getMidPoint(Point p1, Point p2);

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                "}";
    }

}
