package com.sdsmdg.hareshkh.lectureassignment;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by samagra on 02-03-2017.
 */

public class AsiignmentTwoBehaviour extends CoordinatorLayout.Behavior {

    public AsiignmentTwoBehaviour() {
        super();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float translationY = Math.min(0,dependency.getTranslationY()-dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
