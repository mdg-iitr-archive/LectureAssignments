package com.example.arihantjain.servicesassignment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MusicService musicService;
    private boolean isBounded = false,isPlaying = false;
    private Button playBtn,replayButton;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder) service;
            musicService = binder.getService();
            isBounded = true;
            isPlaying = musicService.isPlaying();
            if(isPlaying){
                playBtn.setText("Pause");
            }else {
                playBtn.setText("Play");
                replayButton.setClickable(false);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBounded = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playBtn = (Button)findViewById(R.id.playBtn);
        replayButton = (Button)findViewById(R.id.replayBtn);
    }
    public void playMusic(View view){
        if(!isPlaying){
            if(isBounded){
                musicService.playMusic();
            }
            playBtn.setText("Pause");
            isPlaying = true;
            replayButton.setClickable(true);
        }else {
            playBtn.setText("Play");
            isPlaying = false;
            replayButton.setClickable(false);
            if (isBounded) {
                musicService.stopPlayer();
            }
        }
    }
    public void replayMusic(View view){
        if(isBounded){
            musicService.stopPlayer();
            musicService.playMusic();
        }
        isPlaying = true;
        playBtn.setText("Pause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
}
