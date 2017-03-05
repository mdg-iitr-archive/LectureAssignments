package com.example.shyam.musicplayer;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MyService extends Service {
    private final IBinder binder = new MyServiceBinder();
    private static MediaPlayer mediaPlayer;
    String URL = "http://dot.890m.com/shapeofyou.mp3";

    public MyService() {
    }

    public class MyServiceBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try{
            mediaPlayer.setDataSource(URL);
        }
        catch(Exception e){
            Toast.makeText(this, "Set the URL correctly", Toast.LENGTH_SHORT).show();
        }


        try{
            mediaPlayer.prepare();}
        catch(Exception e){
            Toast.makeText(this, "Set the URL correctly", Toast.LENGTH_SHORT).show();
        }

        RemoteViews notificationView = new RemoteViews(this.getPackageName(),R.layout.notification);

        Intent playIntent = new Intent(this,MusicBroadcastReciever.class);
        playIntent.setAction(Constant.ACTION.PLAY_ACTION);
        PendingIntent playPendingIntent = PendingIntent.getBroadcast(this,0,playIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationView.setOnClickPendingIntent(R.id.notification_button_play,playPendingIntent);

        Intent pauseIntent = new Intent(this,MusicBroadcastReciever.class);
        pauseIntent.setAction(Constant.ACTION.PAUSE_ACTION);
        PendingIntent pausePendingIntent = PendingIntent.getBroadcast(this,0,pauseIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationView.setOnClickPendingIntent(R.id.notification_button_pause,pausePendingIntent);

        Intent stopIntent = new Intent(this,MusicBroadcastReciever.class);
        stopIntent.setAction(Constant.ACTION.STOP_ACTION);
        PendingIntent stopPendingIntent = PendingIntent.getBroadcast(this,0,stopIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationView.setOnClickPendingIntent(R.id.notification_button_stop, stopPendingIntent);

        Notification.Builder mBuilder = new Notification.Builder(this);
        mBuilder.setContentTitle("My Music Player");
        mBuilder.setContent(notificationView);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = mBuilder.build();

        startForeground(Constant.NOTIFICATION_ID.ID_NOTIFICATION,notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void playMusic(){
        mediaPlayer.start();
    }

    public void pauseMusic(){
        mediaPlayer.pause();
    }

    public void stopMusic(){
        mediaPlayer.stop();
        try{
            mediaPlayer.prepare();}
        catch(Exception e){
            Toast.makeText(this, "Set the URL correctly", Toast.LENGTH_SHORT).show();
        }
    }

    public static class MusicBroadcastReciever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if(action.equals(Constant.ACTION.PLAY_ACTION)){
                mediaPlayer.start();
            }else if(action.equals(Constant.ACTION.PAUSE_ACTION)){
                mediaPlayer.pause();
            }else if(action.equals(Constant.ACTION.STOP_ACTION)){
                mediaPlayer.stop();
                try{
                    mediaPlayer.prepare();}
                catch(Exception e){
                    Toast.makeText(context, "Set the URL correctly", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
//    public static class NotificationPlayButtonClicked extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//          mediaPlayer.start();
//        }
//    }
//
//    public static class NotificationPauseButtonClicked extends BroadcastReceiver{
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            mediaPlayer.pause();
//        }
//    }
//
//    public static class NotificationStopButtonClicked extends BroadcastReceiver{
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            mediaPlayer.stop();
//            try{
//                mediaPlayer.prepare();}
//            catch(Exception e){
//                Toast.makeText(context, "Set the URL correctly", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

}
