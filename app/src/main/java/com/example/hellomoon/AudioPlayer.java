package com.example.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;


/**
 * Created by А on 07.08.2017.
 */

public class AudioPlayer  {
    private MediaPlayer mPlayer;
    private  Boolean flag = false;

    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
            flag = false;
        }
    }
    public void play(Context c){
        if (flag == true){
            mPlayer.start();
        }else if (flag == false){
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
        }
    }
    public void pause(){
        if (mPlayer != null){
            mPlayer.pause();
            flag = true;
        }
    }

}
