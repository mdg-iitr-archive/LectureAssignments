package com.example.arihantjain.servicesassignment;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by Arihant Jain on 3/5/2017.
 */

public class MusicService extends Service {
    private MediaPlayer player;
    private String url = "http://dot.890m.com/shapeofyou.mp3";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int code = intent.getIntExtra("code",2);
        if(code == 0){
            playMusic();
        }
        else if(code == 1){
            player.stop();
            stopSelf();
        }
        else{
            player.stop();
            playMusic();
        }
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
                .setAutoCancel(true)
                .setOngoing(true)
                .build();
        startForeground(12,notification);
    }
}
