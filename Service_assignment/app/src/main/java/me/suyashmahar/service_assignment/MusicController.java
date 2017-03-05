package me.suyashmahar.service_assignment;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;

/**
 * Created by suyash on 5/3/17.
 */

public class MusicController extends MediaController {
    private Context context;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public boolean isShowing() {
        return super.isShowing();
    }

    public MusicController(Context context) {
        super(context);
    }

    public MusicController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MusicController(Context context, boolean useFastForward) {
        super(context, useFastForward);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        return super.onTrackballEvent(ev);
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public void setMediaPlayer(MediaPlayerControl player) {
        super.setMediaPlayer(player);
    }

    @Override
    public void setPrevNextListeners(OnClickListener next, OnClickListener prev) {
        super.setPrevNextListeners(next, prev);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void show(int timeout) {
        super.show(timeout);
    }
}
