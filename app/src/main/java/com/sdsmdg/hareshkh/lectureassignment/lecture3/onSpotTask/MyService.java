package com.sdsmdg.hareshkh.lectureassignment.lecture3.onSpotTask;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class MyService extends Service {

    String url;
    private MediaPlayer player;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = new MediaPlayer();
        url = intent.getStringExtra("url");
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            player.setDataSource(url);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Invalid URL", Toast.LENGTH_SHORT).show();
        }

        try{
            player.prepare();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Invalid URL", Toast.LENGTH_SHORT).show();
        }
        player.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Thanks for patient listening", Toast.LENGTH_SHORT).show();

    }
}
