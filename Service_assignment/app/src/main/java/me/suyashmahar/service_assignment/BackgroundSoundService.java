package me.suyashmahar.service_assignment;
//http://www.hrupin,com/wp-content/uploads/mp3/testsong_20_sec.mp3
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import android.content.ContentUris;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.PowerManager;
import android.util.Log;

import java.io.IOException;

public class BackgroundSoundService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    private static final String TAG = null;
    private String musicUrl = "http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3"; // your URL here
    private MediaPlayer player;
    private final IBinder musicBind = new MusicBinder();

    public IBinder onBind(Intent arg0) {
        return musicBind;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();

        initMusicPlayer();
    }

    public void initMusicPlayer(){
        //player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
    }

    public class MusicBinder extends Binder {
        BackgroundSoundService getService() {
            return BackgroundSoundService.this;
        }
    }

    public void playSong(){
        player.reset();
        try{
            player.setDataSource(musicUrl);
            Log.i("MUSIC SERVICE", "setting data source");
        } catch (Exception e){
            Log.e("MUSIC SERVICE", "Error setting data source", e);
        }
        player.prepareAsync();
    }
/*
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();

    }
*/
    public void onBind(Intent intent, int startId) {
        //
    }
    public IBinder onUnBind(Intent arg0) {
        player.stop();
        player.release();
        return null;
    }

    public void onStop() {

    }
    public void onPause() {

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }
}