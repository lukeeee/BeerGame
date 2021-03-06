package com.example.beergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        SoundManager.start(R.raw.open, getApplicationContext());


        new Handler().postDelayed(new Runnable() {
            //Show splash screen for duration of timer

            @Override
            public void run() {
                //Start main activity when timer is over
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);

                // Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
