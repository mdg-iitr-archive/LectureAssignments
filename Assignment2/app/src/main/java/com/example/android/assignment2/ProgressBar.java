package com.example.android.assignment2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;

/**
 * Created by Harshit Bansal on 2/12/2017.
 */

public class ProgressBar extends View{

    int Color;
    int progress=0;
    Paint paint,newPaint;

    ProgressBar(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        TypedArray a=context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ProgressBar,0,0);

       try{
          Color=a.getColor(R.styleable.ProgressBar_Color,BLUE);
       }
       finally {
           a.recycle();
        }
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color);
        newPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        newPaint.setColor(GRAY);
    }


    void setProgress(int a) {
        progress=a;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(progress==0){
            canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),newPaint);
        }
        else {
            canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),newPaint);
            canvas.drawRect(0, 0, progress * canvas.getWidth() / 100, canvas.getHeight(), paint);
        }
    }
}
