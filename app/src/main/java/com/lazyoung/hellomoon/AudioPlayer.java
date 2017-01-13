package com.lazyoung.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void playPause(Context c) {
        if(mPlayer == null) {
            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
              @Override
              public void onCompletion(MediaPlayer mp) {
                  stop();
              }
            });
        }
        
        if(mPlayer.isPlaying()) {
            mPlayer.pause();
        }
        else {
            mPlayer.start();
        }
    }
    
    public boolean isPlaying() {
        return mPlayer.isPlaying();
    }
}
