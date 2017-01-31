package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Utils {

    public static Bitmap scaleToFitWidth(Bitmap b, int width)
    {
        float factor = width / (float) b.getWidth();
        return Bitmap.createScaledBitmap(b, width, (int) (b.getHeight() * factor), true);
    }

    public static int getImageResourceFromString(String img_path, Context context){
        int imageResource = context.getResources().getIdentifier(img_path, null, context.getPackageName());
        return imageResource;
    }

    public static float convertToPixel(float myDPs,Context ctx){
        Resources r = ctx.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, myDPs, r.getDisplayMetrics());
        return px;
    }
}
