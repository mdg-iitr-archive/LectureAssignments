package com.sdsmdg.hareshkh.lectureassignment.aniket;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

/**
 * Created by DELL on 25-02-2017.
 */

public class LayoutBehaviour extends CoordinatorLayout.Behavior<RelativeLayout> {
    public LayoutBehaviour() {
        super();
    }

    public LayoutBehaviour(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        float translationY = Math.min(0, ViewCompat.getTranslationY(dependency) - dependency.getHeight());
        ViewCompat.setTranslationY(child, translationY);
        return true;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        ViewCompat.animate(child).translationY(0).start();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }
}
