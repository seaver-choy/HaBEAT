package com.jtbmilan.habeat.selfhelp.urgesurfing;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jtbmilan.habeat.R;


public class UrgeSurfingActivity extends Activity {
    private MediaPlayer mPlayer;
    private ImageButton mediaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urge_surfing);
        mediaBtn = (ImageButton) findViewById(R.id.mediaBtn);
        mPlayer = MediaPlayer.create(this, R.raw.urgesurfing);
    }

    public void onClickMediaBtn(View view) {
        if(mPlayer.isPlaying()){
            pauseMedia();
        } else {
            playMedia();
        }
    }

    private void playMedia() {
        mPlayer.start();
        mediaBtn.setBackground(getResources()
                .getDrawable(R.drawable.media_pause_btn));
    }

    private void pauseMedia() {
        mPlayer.pause();
        mediaBtn.setBackground(getResources()
                .getDrawable(R.drawable.media_play_btn));
    }

    public void onClickBackBtn(View view) {
        if (mPlayer.isPlaying()) {
            pauseMedia();
        }
        finish();
    }
}
