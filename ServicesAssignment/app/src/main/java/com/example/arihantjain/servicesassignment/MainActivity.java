package com.example.arihantjain.servicesassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    private Intent intent;
    private Button playBtn,replayButton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playBtn = (Button)findViewById(R.id.playBtn);
        replayButton = (Button)findViewById(R.id.replayBtn);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        isPlaying = sharedPreferences.getBoolean("key",false);
        Toast.makeText(this,"" + isPlaying, Toast.LENGTH_SHORT).show();
        if(isPlaying){
            playBtn.setText("Pause");
        }else {
            playBtn.setText("Play");
            replayButton.setClickable(false);
        }
        intent = new Intent(MainActivity.this,MusicService.class);
    }
    public void playMusic(View view){
        if(!isPlaying){
            intent.putExtra("code",0);
            ((Button)view).setText("Pause");
            isPlaying = true;
            replayButton.setClickable(true);
        }else {
            intent.putExtra("code",1);
            ((Button)view).setText("Play");
            isPlaying = false;
            replayButton.setClickable(false);
        }
        editor.putBoolean("key",isPlaying);
        editor.commit();
        startService(intent);
    }
    public void replayMusic(View view){
        intent.putExtra("code",2);
        startService(intent);
        isPlaying = true;
        playBtn.setText("Pause");
        editor.putBoolean("key",isPlaying);
        editor.commit();
    }
}
