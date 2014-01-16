package com.example.beergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity{
    private Button playBtn;
    private Button rulesBtn;
    private Button aboutBtn;
    private ImageView beerLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playBtn = (Button)findViewById(R.id.btnPlay);
        aboutBtn = (Button)findViewById(R.id.btnAbout);
        rulesBtn = (Button)findViewById(R.id.btnRules);
        beerLogo = (ImageView)findViewById(R.id.beerGameImg);

        rulesBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),Rules.class);
                startActivity(i);
            }
        });
        playBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),play.class);
                startActivity(i);
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),About.class);
                startActivity(i);
            }
        });

    }
}
