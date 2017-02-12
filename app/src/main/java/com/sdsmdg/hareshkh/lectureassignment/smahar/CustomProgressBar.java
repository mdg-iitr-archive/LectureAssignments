package com.sdsmdg.hareshkh.lectureassignment.smahar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.sdsmdg.hareshkh.lectureassignment.R;

public class CustomProgressBar extends View {
    private int mForeColor = ContextCompat.getColor(getContext(), R.color.colorAccent); // TODO: use a default from R.color...
    private Paint mProgressPaint;

    private int mProgress;
    private int mMaxProgress;

    public CustomProgressBar(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CustomProgressBar, defStyle, 0);
/*
        mExampleString = a.getString(
                R.styleable.CustomProgressBar_exampleString);*/

        mForeColor = a.getColor(
                R.styleable.CustomProgressBar_foreColor,
                mForeColor
        );

        mProgress = a.getInteger(
                R.styleable.CustomProgressBar_progress,
                0
        );
        mMaxProgress = a.getInteger(
                R.styleable.CustomProgressBar_maxProgress,
                100
        );


        a.recycle();

        mProgressPaint = new Paint();
        mProgressPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        // Update TextPaint and text measurements from attributes
        invalidateProgressPaintAndMeasurements();
    }

    private void invalidateProgressPaintAndMeasurements() {
        mProgressPaint.setColor(mForeColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        int progressRectWidth = (contentWidth*mProgress)/mMaxProgress;
        progressRectWidth = contentWidth < progressRectWidth ? contentWidth : progressRectWidth;

        canvas.drawRect(paddingLeft, paddingTop, paddingLeft + progressRectWidth, contentHeight + paddingTop, mProgressPaint);
    }

    public int getForeColor() {
        return mForeColor;
    }
    public void setForeColor(int exampleColor) {
        mForeColor = exampleColor;
        invalidateProgressPaintAndMeasurements();
    }

    public int getMaxProgress() {
        return mMaxProgress;
    }

    public void SetMaxProgress(int mSetMaxProgress) {
        this.mMaxProgress = mSetMaxProgress;
    }

    public int getProgress() {
        return mProgress;
    }

    public void setProgress(int mProgress) {
        Log.i("Flag", String.valueOf(mProgress));
        this.mProgress = mProgress;
        invalidate();
        invalidateProgressPaintAndMeasurements();
    }
}
