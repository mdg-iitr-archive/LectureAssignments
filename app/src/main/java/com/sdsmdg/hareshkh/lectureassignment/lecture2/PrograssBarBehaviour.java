package com.sdsmdg.hareshkh.lectureassignment.lecture2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.sdsmdg.hareshkh.lectureassignment.R;

public class PrograssBarBehaviour extends CoordinatorLayout.Behavior<ProgressBar> {

    public PrograssBarBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ProgressBar child, View dependency) {
        return dependency instanceof SeekBar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ProgressBar child, View dependency) {
        SeekBar s = (SeekBar) dependency.findViewById(R.id.seek_bar);
        child.setProgress(s.getProgress());
        return true;
    }

}

