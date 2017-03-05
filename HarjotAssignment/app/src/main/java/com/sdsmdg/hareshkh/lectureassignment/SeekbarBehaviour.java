package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by shyam on 05-Feb-17.
 */

public class SeekbarBehaviour extends CoordinatorLayout.Behavior<SeekBar> {

    public SeekbarBehaviour(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, SeekBar child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, SeekBar child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY()-dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
