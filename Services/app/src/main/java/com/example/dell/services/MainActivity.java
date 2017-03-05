package com.example.dell.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.service.media.MediaBrowserService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.dell.services.PlayService.mediaPlayer;

public class MainActivity extends AppCompatActivity {
   // public static int currentPos=0;
    private boolean musicBound=false;
    private PlayService musicSrv;
    private static boolean paused=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play=(Button)findViewById(R.id.play);
        final Button pause=(Button)findViewById(R.id.pause);
        Button stop=(Button)findViewById(R.id.stop);
        play.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(MainActivity.this,PlayService.class);
        bindService(i, musicConnection, Context.BIND_AUTO_CREATE);
        startService(i);
    }
});
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(!paused) {
                            pause.setText("resume");
                            musicSrv.pauseMusic();
                            paused=true;
                        }
            else
                    {
                        pause.setText("pause");
                        musicSrv.resumeMusic();
                        paused=false;
                    }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PlayService.class);
                unbindService(musicConnection);
                stopService(i);

            }
        });
    }

    private ServiceConnection musicConnection = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            PlayService.MusicBinder binder = (PlayService.MusicBinder)service;
            musicSrv = binder.getService();
            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicBound=false;
        }
    };
}
