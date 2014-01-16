package com.example.beergame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class play extends Activity implements View.OnClickListener {
    private Button hitMe;
    private TextView play;
    private Button Ace;
    private Button King;
    private Button Queen;
    private Button Jack;
    private Button Ten;
    private Button Nine;
    private Button Eight;
    private Button Seven;
    private Button Six;
    private Button B5;
    private Button B4;
    private Button B3;
    private Button B2;
    private Button R5;
    private Button R4;
    private Button R3;
    private Button R2;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beergame_activity);
        hitMe = (Button)findViewById(R.id.newCard);
        play = (TextView)findViewById(R.id.playText);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Ace = (Button)findViewById(R.id.ace);
        King = (Button)findViewById(R.id.king);
        Queen = (Button)findViewById(R.id.queen);
        Jack = (Button)findViewById(R.id.jack);
        Ten = (Button)findViewById(R.id.ten);
        Nine = (Button)findViewById(R.id.nine);
        Eight = (Button)findViewById(R.id.eight);
        Seven = (Button)findViewById(R.id.seven);
        Six = (Button)findViewById(R.id.six);
        B5 = (Button)findViewById(R.id.bFive);
        B4 = (Button)findViewById(R.id.bFour);
        B3 = (Button)findViewById(R.id.bThree);
        B2 = (Button)findViewById(R.id.bTwo);
        R5 = (Button)findViewById(R.id.rFive);
        R4 = (Button)findViewById(R.id.rFour);
        R3 = (Button)findViewById(R.id.rThree);
        R2 = (Button)findViewById(R.id.rTwo);
        Ace.setVisibility(View.INVISIBLE);
        King.setVisibility(View.INVISIBLE);
        Queen.setVisibility(View.INVISIBLE);
        Jack.setVisibility(View.INVISIBLE);
        Ten.setVisibility(View.INVISIBLE);
        Nine.setVisibility(View.INVISIBLE);
        Eight.setVisibility(View.INVISIBLE);
        Seven.setVisibility(View.INVISIBLE);
        Six.setVisibility(View.INVISIBLE);
        B5.setVisibility(View.INVISIBLE);
        B4.setVisibility(View.INVISIBLE);
        B3.setVisibility(View.INVISIBLE);
        B2.setVisibility(View.INVISIBLE);
        R5.setVisibility(View.INVISIBLE);
        R4.setVisibility(View.INVISIBLE);
        R3.setVisibility(View.INVISIBLE);
        R2.setVisibility(View.INVISIBLE);

        hitMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == hitMe){
            play.setVisibility(View.INVISIBLE);
        }
    }
}