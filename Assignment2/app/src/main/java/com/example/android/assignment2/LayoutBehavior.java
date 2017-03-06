package com.example.android.assignment2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

/**
 * Created by Harshit Bansal on 3/6/2017.
 */

public class LayoutBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {
/*
    LayoutBehavior(){
        super();
    }
    LayoutBehavior(Context ctx, AttributeSet attr){
        super(ctx,attr);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        dependency.getHeight();
        float childHeight=child.getY();
        child.setY(childHeight-dependency.getHeight());
        return true;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, View child, View dependency) {
        child.setY(child.getY());
    }
    */
private final static String TAG = "CustomBehavior";
    private float mFrTranslationY;
    public LayoutBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {

        if(dependency instanceof Snackbar.SnackbarLayout){
            updateFabTranslationForSnackbar(parent, child, dependency);
            ViewCompat.setTranslationY(child, mFrTranslationY);
        }
        return false;
    }
    @Override
    public void onDependentViewRemoved(final CoordinatorLayout parent, final RelativeLayout child, final View dependency) {
        super.onDependentViewRemoved(parent, child, dependency);
    }

    private void updateFabTranslationForSnackbar(CoordinatorLayout parent, final RelativeLayout fab, View snackbar) {
        mFrTranslationY = getFabTranslationYForSnackbar(parent, fab, snackbar);
    }

    private float getFabTranslationYForSnackbar(CoordinatorLayout parent, RelativeLayout fab, View snackbar) {
        float minOffset = 0;
        minOffset = Math.min(minOffset, ViewCompat.getTranslationY(snackbar) - snackbar.getHeight());
        return minOffset;
    }
}
