package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shyam on 06-Feb-17.
 */

public class ProgressRectangleBehavior extends CoordinatorLayout.Behavior<ProgressRectangle>{
    public ProgressRectangleBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ProgressRectangle child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ProgressRectangle child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY()-dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
