package com.yang.user.myplayvedio;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
        String videourl = Environment.getExternalStorageDirectory().getPath() + File.separator + "test1.mp4";
        videoView.setMediaController(new MediaController(this));
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
        videoView.setVideoURI(Uri.parse(videourl));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0.0f,0.0f);
                mp.start();
            }
        });
//        videoView.setVolume(0.0f,0.0f);
        videoView.start();
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(MainActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }
}
