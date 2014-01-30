package com.example.beergame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.gms.ads.*;

public class Banner extends Activity {
    private AdView adView;
    String hej = "0445b7141d9d4e1b";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Create the adView.
        adView = new AdView(this);
        adView.setAdUnitId(hej);
        adView.setAdSize(AdSize.BANNER);

        // Lookup your LinearLayout assuming it's been given
        // the attribute android:id="@+id/mainLayout".
        LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);

        // Add the adView to it.
        layout.addView(adView);

        // Initiate a generic request.

        AdRequest adRequest = new AdRequest.Builder()     // Emulator
                //.addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4") // My Galaxy Nexus test phone
                .build();

        // Load the adView with the ad request.
        adView.loadAd(adRequest);
    }

    @Override
    public void onPause() {
        adView.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        adView.resume();
    }

    @Override
    public void onDestroy() {
        adView.destroy();
        super.onDestroy();
    }
}