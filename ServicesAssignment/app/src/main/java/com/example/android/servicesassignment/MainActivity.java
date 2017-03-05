package com.example.android.servicesassignment;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity{

    private MusicPlayerServices musicPlayerServices;
    private Intent i;
    private boolean musicBound=false;
    private boolean isStopped=false;

    private ServiceConnection musicConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicPlayerServices.MusicBinder binder = (MusicPlayerServices.MusicBinder) service;
            musicPlayerServices = binder.getService();
            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound=false;
        }
    };
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button play=(Button)findViewById(R.id.play_button);

            play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(MainActivity.this,MusicPlayerServices.class);
                musicBound=true;
                if(isStopped == false)
                    bindService(i,musicConnection, Context.BIND_AUTO_CREATE);
                else{
                    isStopped=false;
                    startService(i);
                }
            }
        });
            Button pause=(Button)findViewById(R.id.pause_button);
            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(musicBound == true && musicPlayerServices != null)
                    musicPlayerServices.onPause();
                    else
                        Toast.makeText(MainActivity.this, "Music Already Stopped!", Toast.LENGTH_SHORT).show();
                }
            });
            Button resume=(Button)findViewById(R.id.resume_button);
            resume.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(musicBound == true && musicPlayerServices != null)
                    musicPlayerServices.onResume();
                    else
                        Toast.makeText(MainActivity.this, "Music Already Stopped!", Toast.LENGTH_SHORT).show();
                }
            });
            Button stop=(Button)findViewById(R.id.stop_button);
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(musicBound == true && musicPlayerServices != null) {
                        musicPlayerServices.onUnbind(i);
                        musicBound = false;
                        stopService(i);
                        isStopped=true;
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Music Already Stopped!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }


}
