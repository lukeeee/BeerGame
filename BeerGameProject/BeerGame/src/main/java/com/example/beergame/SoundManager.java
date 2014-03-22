package com.example.beergame;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by Lukas on 2014-03-21.
 */
public class SoundManager {

play pl = new play();
    public static void start(int source, Context context){
        if(HelperClass.Sounds.app_sounds)
        try{
            MediaPlayer mp = MediaPlayer.create(context, source);
            mp.start();
        } catch (Exception e){
            Log.i("MPerror", "" + e);
        }
        else{
            Log.i("sounds off", "no sound");
        }

    }

}
