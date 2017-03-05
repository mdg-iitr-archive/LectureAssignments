package me.suyashmahar.service_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
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
import java.util.Random;
import android.app.Notification;
import android.app.PendingIntent;

public class MainActivity extends AppCompatActivity implements MediaPlayerControl {
    private BackgroundSoundService musicService;
    private Intent playIntent;
    private boolean musicBound = false;

    private ImageView playPauseButton, stopButton;
    private SeekBar seekBar;
    private MusicController controller;

    private int lastPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.main_activity_seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekTo(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        playPauseButton = (ImageView) findViewById(R.id.main_activity_start_btn);
        playPauseButton.setImageResource(R.drawable.ic_play);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMusicState();
            }
        });


        stopButton = (ImageView) findViewById(R.id.main_activity_stop_btn);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicService.pausePlayer();
            }
        });

        setController();
    }

    public void toggleMusicState(){
        if (isPlaying()){
            playPauseButton.setImageResource(R.drawable.ic_play);
            lastPos = getCurrentPosition();
            pause();
        } else {
            playPauseButton.setImageResource(R.drawable.ic_pause);
            musicService.playSong();
        }
        seekBar.setMax(getDuration());
    }

    public void setController(){
        controller = new MusicController(this);

        controller.setPrevNextListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Unable to change! ;-)", Toast.LENGTH_SHORT).show();
                controller.show(0);
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
        if (musicService != null && musicBound && musicService.isPng()){
            return musicService.getPosn();
        } else return 0;
    }

    @Override
    public int getDuration() {
        if (musicService != null && musicBound && musicService.isPng()){
            return musicService.getDur();
        } else return 0;
    }

    @Override
    public boolean isPlaying() {
        if(musicService!=null && musicBound){
            return musicService.isPng();
        } else return false;
    }

    @Override
    public void pause() {
        musicService.pausePlayer();
    }

    @Override
    public void start() {
        musicService.go();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public void seekTo(int pos) {
        musicService.seek(pos);
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
