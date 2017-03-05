package com.sdsmdg.hareshkh.lectureassignment.rohanbh;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sdsmdg.hareshkh.lectureassignment.R;

public class CustomProgressBar extends View {

    private int barColor;
    private int barHeight=8;
    private Paint paint;
    int progress;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(attrs);
        progress=0;
        setPaint();
    }

    private void setPaint() {
        paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(barColor);
    }

    private void setupAttributes(AttributeSet attrs) {
        // Obtain a typed array of attributes
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBarView, 0, 0);
        // Extract custom attributes into member variables
        try {
            barColor = a.getColor(R.styleable.CustomProgressBarView_ProgressBarColor, Color.BLACK);
        } finally {
            // TypedArray objects are shared and must be recycled.
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int progressWidth=canvas.getWidth()*progress/100;
        canvas.drawRect(0,0,progressWidth,barHeight,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w=MeasureSpec.getSize(widthMeasureSpec);
        int height=barHeight+getPaddingTop()+getPaddingBottom();
        int h=resolveSizeAndState(height,heightMeasureSpec,0);
        setMeasuredDimension(w,h);

    }

    public int getBarColor() {
        return barColor;
    }

    public void setBarColor(int barColor) {
        this.barColor = barColor;
        invalidate();
        requestLayout();
    }
}
