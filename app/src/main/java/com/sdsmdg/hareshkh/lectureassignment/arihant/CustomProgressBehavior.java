package com.sdsmdg.hareshkh.lectureassignment.arihant;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Arihant Jain on 2/9/2017.
 */

public class CustomProgressBehavior extends CoordinatorLayout.Behavior<ProgressBar>{

    public CustomProgressBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ProgressBar child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ProgressBar child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
