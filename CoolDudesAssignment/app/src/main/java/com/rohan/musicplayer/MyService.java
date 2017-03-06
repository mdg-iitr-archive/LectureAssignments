package com.rohan.musicplayer;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.IOException;


public class MyService extends Service {

    private MediaPlayer mPlayer = new MediaPlayer();
    private boolean playerIsSet = false;

    public interface BoundServiceListener {

        public void finishedDownloading();
    }

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }

        public void setListener(BoundServiceListener listener) {
            mListener = listener;
        }
    }

    private final IBinder mBinder = new MyBinder();
    private BoundServiceListener mListener;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (!playerIsSet) {
            new LoadDataInBackground().execute();
        }
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mPlayer.stop();
        mPlayer.release();
        playerIsSet = false;
        stopSelf();
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!playerIsSet) {
            setUpPlayer();
            playerIsSet = true;
        }
        if (!mPlayer.isPlaying())
            mPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    private class LoadDataInBackground extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            setUpPlayer();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            playerIsSet = true;
            if (mListener != null)
                mListener.finishedDownloading();
        }
    }

    public void setUpPlayer() {
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            String URL = "http://dot.890m.com/shapeofyou.mp3";
            mPlayer.setDataSource(URL);
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (SecurityException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mPlayer.prepare();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }
    }

    public void startPlayer() {
        mPlayer.start();
    }

    public void pausePlayer() {
        mPlayer.pause();
    }

    public void stopPlayer() {
        mPlayer.stop();
        try {
            mPlayer.prepare();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }
    }

    public void showNotification() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("Shape of You")
                .setContentText("Tap to open app")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setTicker("Music Player is running")
                .build();
        startForeground(101, notification);
    }

    public void removeNotification() {
        stopForeground(true);
    }
}
