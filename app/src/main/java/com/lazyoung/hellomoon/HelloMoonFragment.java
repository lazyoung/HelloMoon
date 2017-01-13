package com.lazyoung.hellomoon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment{
    private AudioPlayer mPlayer = new AudioPlayer();
    private Button mPlayButton;
    private Button mStopButton;
    private int playOrPause;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        playOrPause = R.string.hellomoon_play;
        setRetainInstance(true);
    }    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);
        
        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playPauseButton);
        mPlayButton.setText(playOrPause);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.playPause(getActivity());
                if(mPlayer.isPlaying()) {
                    playOrPause = R.string.hellomoon_pause;
                }
                else {
                    playOrPause = R.string.hellomoon_play;
                }
                mPlayButton.setText(playOrPause);
            }
        });
           
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                playOrPause = R.string.hellomoon_play;
                mPlayButton.setText(playOrPause);
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
