package com.sdsmdg.hareshkh.lectureassignment;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by samagra on 05-03-2017.
 */

public class MusicPlayerService extends Service implements MediaPlayer.OnPreparedListener , MediaPlayer.OnErrorListener ,
MediaPlayer.OnCompletionListener{

    private MediaPlayer mPlayer ;
    String url = "http://dot.890m.com/shapeofyou.mp3";
    private final IBinder musicBind = new MusicBinder();
    //media player

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = new MediaPlayer();
        initMediaPlayer();
    }

    /**
     * creating a mdia player class to initialize the media player object
     */
    public void initMediaPlayer(){
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setOnPreparedListener(this);
        mPlayer.setOnCompletionListener(this);
        mPlayer.setOnErrorListener(this);
    }

    public class MusicBinder extends Binder {
        MusicPlayerService getService() {
            return MusicPlayerService.this;
        }
    }

    //current position
    private int songPosn;

    @Override
    public boolean onUnbind(Intent intent) {
        mPlayer.stop();
        mPlayer.release();
        return false;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {


    }


    public void playSong(){
        Boolean isPaused = !mPlayer.isPlaying() && mPlayer.getCurrentPosition() > 1;
        if (isPaused)
            mPlayer.start();
        else {mPlayer.reset();

        try {
            mPlayer.setDataSource(url);
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
        mPlayer.start();}


    }
    public void pauseSong(){
        mPlayer.pause();
    }

}
