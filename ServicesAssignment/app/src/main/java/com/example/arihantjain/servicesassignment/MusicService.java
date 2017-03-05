package com.example.arihantjain.servicesassignment;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by Arihant Jain on 3/5/2017.
 */

public class MusicService extends Service {
    private IBinder mBinder = new MusicBinder();
    private MediaPlayer player;
    private String url = "http://dot.890m.com/shapeofyou.mp3";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null){
            player.release();
            player = null;
        }
    }
    public void playMusic(){
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            player.setDataSource(url);
            player.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
        player.start();
        Notification notification;
        PendingIntent pendingIntent = PendingIntent.getActivity(MusicService.this,
                11,new Intent(MusicService.this,MainActivity.class),0);
        notification = new Notification.Builder(MusicService.this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Music")
                .setContentText("Music service is on.")
                .setContentIntent(pendingIntent)
                .build();
        startForeground(12,notification);
    }
    public boolean isPlaying(){
        if(player!=null){
            if(player.isPlaying())
                return true;
        }
        return false;
    }
    public void stopPlayer(){
        player.stop();
        stopForeground(true);
    }
    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }
}
