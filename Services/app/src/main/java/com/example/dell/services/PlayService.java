package com.example.dell.services;


import android.app.Service;
import android.content.Intent;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.security.Provider;


/**
 * Created by DELL on 01-03-2017.
 */

public class PlayService extends Service implements MediaPlayer.OnCompletionListener,MediaPlayer.OnPreparedListener{

    public static MediaPlayer mediaPlayer;
    private static int length;
    private final IBinder musicBind = new MusicBinder();
    String url = "http://dot.890m.com/shapeofyou.mp3";

    @Override
    public void onCreate() {
        mediaPlayer=new MediaPlayer();
        Toast.makeText(this,"in onCreate",Toast.LENGTH_LONG).show();
        mediaPlayer =MediaPlayer.create(this,R.raw.aka);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


    }
    @Override
    public int onStartCommand (Intent intent, int flags, int startId)
    {    Toast.makeText(this,"in onStartCommand",Toast.LENGTH_LONG).show();
        mediaPlayer.start();
        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this,"in onDestroy",Toast.LENGTH_LONG).show();
        mediaPlayer.stop();

    }


    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.pause();
        Toast.makeText(this,"in onUnbind",Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        Toast.makeText(this,"in onRebind ",Toast.LENGTH_LONG).show();
        mediaPlayer.start();

    }

    public void pauseMusic()
    {
            mediaPlayer.pause();
            length=mediaPlayer.getCurrentPosition();
        Toast.makeText(this,"in pauseMusic and length is "+length,Toast.LENGTH_LONG).show();
    }

    public void resumeMusic()
    {
            mediaPlayer.seekTo(length);
        Toast.makeText(this,"in resumeMusic and resumed at "+length,Toast.LENGTH_LONG).show();

        mediaPlayer.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"in onBind",Toast.LENGTH_LONG).show();
        mediaPlayer.start();
        return musicBind;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {


    }
    public class MusicBinder extends Binder {
        PlayService getService() {
            return PlayService.this;
        }
    }
}
