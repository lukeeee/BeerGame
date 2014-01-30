package com.example.beergame;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class play extends Fragment {
    private TextView play;
    private static final Integer[] mImageIds =
            { R.drawable.c_a, R.drawable.c_eight, R.drawable.c_five,R.drawable.c_four,R.drawable.c_j,R.drawable.c_k,R.drawable.c_nine,R.drawable.c_q,R.drawable.c_seven,
                    R.drawable.c_six,R.drawable.c_ten,R.drawable.c_three,R.drawable.c_two,R.drawable.s_a, R.drawable.s_eight, R.drawable.s_five,R.drawable.s_four,R.drawable.s_j,R.drawable.s_k,R.drawable.s_nine,R.drawable.s_q,R.drawable.s_seven,
                    R.drawable.s_six,R.drawable.s_ten,R.drawable.s_three,R.drawable.s_two,R.drawable.h_a, R.drawable.h_eight, R.drawable.h_five,R.drawable.h_four,R.drawable.h_j,R.drawable.h_k,R.drawable.h_nine,R.drawable.h_q,R.drawable.h_seven,
                    R.drawable.h_six,R.drawable.h_ten,R.drawable.h_three,R.drawable.h_two,R.drawable.d_a, R.drawable.d_eight, R.drawable.d_five,R.drawable.d_four,R.drawable.d_j,R.drawable.d_k,R.drawable.d_nine,R.drawable.d_q,R.drawable.d_seven,
                    R.drawable.d_six,R.drawable.d_ten,R.drawable.d_three,R.drawable.d_two};
    private ImageView gamecards;
    private ImageView back;
    private TextView rule;
    private static final Random rgenerator = new Random();

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.beergame_activity, container, false);
        play = (TextView)rootView.findViewById(R.id.playText);

        back = (ImageView)rootView.findViewById(R.id.back);
        rule = (TextView)rootView.findViewById(R.id.rule);
        rule.setVisibility(View.INVISIBLE);
        gamecards = (ImageView)rootView.findViewById(R.id.gamecards);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        Integer q = mImageIds[rgenerator.nextInt(mImageIds.length)];
        changeImageResource();
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                back.setVisibility(View.INVISIBLE);
                play.setVisibility(View.INVISIBLE);
                rule.setVisibility(View.VISIBLE);
            }
        });;
        gamecards.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeImageResource();
            }
        });;


        return rootView;

    }
    public void changeImageResource()
    {
        int i = rgenerator.nextInt(51);
        gamecards.setImageResource(mImageIds[i]);
    }

        }
