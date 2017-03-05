package me.suyashmahar.service_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.os.IBinder;
import android.content.ComponentName;
import me.suyashmahar.service_assignment.BackgroundSoundService.MusicBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.MenuItem;
import android.widget.MediaController.MediaPlayerControl;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MediaPlayerControl {
    private BackgroundSoundService musicService;
    private Intent playIntent;
    private boolean musicBound = false;

    private Button playPauseButton;
    private MusicController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPauseButton = (Button) findViewById(R.id.main_activity_start_btn);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                musicService.playSong();

            }
        });
        setController();
    }

    public void setController(){
        controller = new MusicController(this);

        controller.setPrevNextListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Unable to change! ;-)", Toast.LENGTH_SHORT).show();
            }
        },new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Unable to change! ;-)", Toast.LENGTH_SHORT).show();
            }
        });

        controller.setMediaPlayer(this);
        controller.setAnchorView(findViewById(R.id.main_activity_start_btn));
        controller.setEnabled(true);
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void pause() {

    }

    @Override
    public void start() {

    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public void seekTo(int pos) {

    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    private ServiceConnection musicConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicBinder binder = (MusicBinder) service;

            musicService = binder.getService();

            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "This ", Toast.LENGTH_LONG).show();
        if (playIntent == null){
            playIntent = new Intent(this, BackgroundSoundService.class);
            bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
            startService(playIntent);
        }
    }

    @Override
    protected void onDestroy() {
        stopService(playIntent);
        musicService = null;
        super.onDestroy();

    }
}
