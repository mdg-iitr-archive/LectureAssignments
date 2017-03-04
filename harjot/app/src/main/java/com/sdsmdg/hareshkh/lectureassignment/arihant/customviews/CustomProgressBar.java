package com.sdsmdg.hareshkh.lectureassignment.arihant.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sdsmdg.hareshkh.lectureassignment.R;

/**
 * Created by Arihant Jain on 2/12/2017.
 */

public class CustomProgressBar extends View{
    private int color;
    private Paint paint;
    private int progress;
    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        color = attr.getColor(R.styleable.CustomProgressBar_progressColorTint,Color.parseColor("#ffffff"));
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        progress = 0;
    }

    public void setProgress(int prg){
        progress = prg;
        invalidate();
        postInvalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,progress*canvas.getWidth()/100,canvas.getHeight(),paint);
    }
}
