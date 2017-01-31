package com.sdsmdg.hareshkh.lectureassignment;

import android.graphics.Bitmap;

public class Utils {

    public static Bitmap scaleToFitWidth(Bitmap b, int width)
    {
        float factor = width / (float) b.getWidth();
        return Bitmap.createScaledBitmap(b, width, (int) (b.getHeight() * factor), true);
    }

}
