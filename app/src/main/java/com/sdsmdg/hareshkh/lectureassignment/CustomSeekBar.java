package com.sdsmdg.hareshkh.lectureassignment;

import android.content.Context;
import android.widget.SeekBar;

/**
 * Created by samagra on 02-03-2017.
 */

public class CustomSeekBar extends SeekBar {
    public CustomSeekBar(Context context) {
        super(context);
    }
    int progressBarWidth = getWidth();
    int progressBarHeight = getHeight();
    int thumbOffSet = getThumbOffset();
}
