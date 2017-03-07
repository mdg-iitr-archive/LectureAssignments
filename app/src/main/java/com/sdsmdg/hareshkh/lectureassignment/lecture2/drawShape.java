package com.sdsmdg.hareshkh.lectureassignment.lecture2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import static android.graphics.Color.BLACK;


public class drawShape extends View {

    Paint paint = new Paint();

    public drawShape(Context context) {
        super(context);
        paint.setColor(BLACK);
        paint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.setDensity(0);
        canvas.drawRect(5,5,canvas.getWidth()-5,50, paint);

    }

}
