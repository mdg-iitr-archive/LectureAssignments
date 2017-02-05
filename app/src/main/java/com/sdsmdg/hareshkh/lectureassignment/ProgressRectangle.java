package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shyam on 04-Feb-17.
 */

public class ProgressRectangle extends View {

    public ProgressRectangle(Context context){
        super(context);
    }

    Canvas canvas;
    Paint paintBackground;
    Paint paintProgress;
    int progressColor;
    int backgroundColor;
    int progress = 0;

    public ProgressRectangle (Context context, AttributeSet attributeSet){
        super(context,attributeSet);

        TypedArray array = context.obtainStyledAttributes(attributeSet,R.styleable.ProgressRectangle);
        progressColor = array.getColor(R.styleable.ProgressRectangle_progressColor,Color.rgb(255,140,0));
        backgroundColor = array.getColor(R.styleable.ProgressRectangle_backgroundColor,Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        paintBackground = new Paint();
        paintBackground.setStyle(Paint.Style.FILL);
        paintBackground.setColor(backgroundColor);
        paintProgress = new Paint();
        paintProgress.setColor(progressColor);
        paintProgress.setStyle(Paint.Style.FILL);
        canvas.drawRect(progress*canvas.getWidth()/100,550,canvas.getWidth(),650,paintBackground);
        canvas.drawRect(0,550,progress*canvas.getWidth()/100,650,paintProgress);
    }

    public void draw(int progress){
        this.progress = progress;
        invalidate();
    }

}
