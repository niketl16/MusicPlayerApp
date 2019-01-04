package com.example.niketl16.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int pauseposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        play=(Button) findViewById(R.id.btn_play);
        pause=(Button) findViewById(R.id.btn_pause);
        stop=(Button) findViewById(R.id.btn_stop);



    //play.setOnClickListener(getApplicationContext());
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case (R.id.btn_play):
    if (mediaPlayer==null) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.endgame);
        mediaPlayer.start();
    }
        else if (!mediaPlayer.isPlaying()){
            mediaPlayer.seekTo(pauseposition);
            mediaPlayer.start();
        }

            break;

            case (R.id.btn_pause):
                if (mediaPlayer!=null) {
                    mediaPlayer.pause();
                    pauseposition=mediaPlayer.getCurrentPosition();
                }break;

            case (R.id.btn_stop):
                if (mediaPlayer!=null) {
                    mediaPlayer.stop();
                mediaPlayer=null;
                }              break;


        }


    }
}
