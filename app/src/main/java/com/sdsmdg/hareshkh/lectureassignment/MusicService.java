package com.sdsmdg.hareshkh.lectureassignment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class MusicService extends Service {

    private MediaPlayer mp = new MediaPlayer();
    String url = "http://dot.890m.com/shapeofyou.mp3";


    private final Binder binder= new MyBinder();




    public MusicService() {
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try
        {
            mp.setDataSource(url);
            mp.prepare();

        }
        catch (Exception e)
        {
         Log.d("error","ugh");
        }

        Log.d("Service","hello");

    }

    @Override
    public IBinder onBind(Intent intent)
    {
     return binder;
    }


    public  void onPlay()
    {

        if (!mp.isPlaying())
        {
            mp.start();
        }

    }

    public  void onPause()
    {
    if (mp.isPlaying())
        mp.pause();
    }

    public  void onStop()
    {
        if (mp.isPlaying())
        {
            mp.pause();
            mp.seekTo(0);
        }
    }

    public class MyBinder extends  Binder
    {
        MusicService getService ()
        {
            return MusicService.this;
        }
    }

}

