package com.example.android.servicesassignment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Harshit Bansal on 3/1/2017.
 */

public class MusicPlayerServices extends Service{

    String songUrl="http://dot.890m.com/shapeofyou.mp3";
    MediaPlayer player;
    private final IBinder musicBind=new MusicBinder();

    public class MusicBinder extends Binder{
        MusicPlayerServices getService(){
            return MusicPlayerServices.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {

        player=new MediaPlayer();
        try {
            player.setDataSource(songUrl);
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }

        try {
            player.prepare();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }
        player.start();

        return musicBind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        player.stop();
        return false;
    }

    @Override
    public void onCreate() {
        NotificationCompat.Builder notification;
        NotificationManager manager;

        PendingIntent pendingIntent = PendingIntent.getActivity(MusicPlayerServices.this,
                11,new Intent(MusicPlayerServices.this,MainActivity.class),0);
        notification = new NotificationCompat.Builder(MusicPlayerServices.this);
        notification.setContentTitle("Services Assignment");
        notification.setContentText("New Music Player App");
        notification.setTicker("New Message Alert!");
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setContentIntent(pendingIntent);
        notification.setPriority(0);

        manager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification.build());
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            player.prepare();
        } catch (IllegalStateException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
        }
        player.start();
        return super.onStartCommand(intent,flags,startId);
    }

    public void onResume(){
        player.seekTo(player.getCurrentPosition());
        player.start();
    }
    public void onPause(){
        player.pause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
