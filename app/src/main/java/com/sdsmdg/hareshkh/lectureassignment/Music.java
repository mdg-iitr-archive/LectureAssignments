package com.sdsmdg.hareshkh.lectureassignment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.Icon;
import android.os.IBinder;
import android.provider.Telephony;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class Music extends AppCompatActivity {
    private MusicService ms;

    private boolean bounded = false;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MusicService.MyBinder mbinder= (MusicService.MyBinder) service;
            ms=mbinder.getService();
            bounded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
                bounded = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        FloatingActionButton playBtn=(FloatingActionButton)findViewById(R.id.fabPlay);
        FloatingActionButton pauseBtn=(FloatingActionButton)findViewById(R.id.fabPause);
        FloatingActionButton stopBtn=(FloatingActionButton)findViewById(R.id.fabStop);


        PendingIntent pi= PendingIntent.getActivity(this, 123, new Intent(this,Music.class),PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder= (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Music Player")
                .setContentText("Music is playing")
                .setContentIntent(pi);
        Notification nf;

        {
            nf = mBuilder.build();
        }

        nf.flags=Notification.FLAG_ONGOING_EVENT;

        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        nm.notify(123,nf);




        playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(bounded){
                          ms .onPlay();


                        }
                    }
                });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ms.onPause();

            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ms.onStop();


            }
        });
        s

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i=new Intent(Music.this,MusicService.class);
        startService(i);
        bindService(i,connection, Context.BIND_AUTO_CREATE);
    }


}
