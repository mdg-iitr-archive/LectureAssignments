package me.suyashmahar.service_assignment;
//http://www.hrupin,com/wp-content/uploads/mp3/testsong_20_sec.mp3
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
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
    private static final int NOTIFY_ID=1;


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
        stopForeground(true);
    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        Intent notIntent = new Intent(this, MainActivity.class);
        notIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendInt = PendingIntent.getActivity(this, 0,
                notIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(this);

        builder.setContentIntent(pendInt)
                .setSmallIcon(R.drawable.ic_play)
                .setTicker("Some song...")
                .setOngoing(true)
                .setContentTitle("Playing")
        .setContentText("Some song...");
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        Notification not = builder.build();

        startForeground(NOTIFY_ID, not);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    public int getPosn(){
        return player.getCurrentPosition();
    }

    public int getDur(){
        return player.getDuration();
    }

    public boolean isPng(){
        return player.isPlaying();
    }

    public void pausePlayer(){
        player.pause();
    }

    public void seek(int posn){
        player.seekTo(posn);
    }

    public void go(){
        player.start();
    }
}