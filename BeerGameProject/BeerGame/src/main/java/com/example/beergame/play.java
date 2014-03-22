package com.example.beergame;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class play extends Fragment implements View.OnClickListener {
    private TextView play;
    private static final Integer[] mImageIds =
            { R.drawable.c_a, R.drawable.c_eight, R.drawable.c_five,R.drawable.c_four,R.drawable.c_j,R.drawable.c_k,R.drawable.c_nine,R.drawable.c_q,R.drawable.c_seven,
                    R.drawable.c_six,R.drawable.c_ten,R.drawable.c_three,R.drawable.c_two,R.drawable.s_a, R.drawable.s_eight, R.drawable.s_five,R.drawable.s_four,R.drawable.s_j,R.drawable.s_k,R.drawable.s_nine,R.drawable.s_q,R.drawable.s_seven,
                    R.drawable.s_six,R.drawable.s_ten,R.drawable.s_three,R.drawable.s_two,R.drawable.h_a, R.drawable.h_eight, R.drawable.h_five,R.drawable.h_four,R.drawable.h_j,R.drawable.h_k,R.drawable.h_nine,R.drawable.h_q,R.drawable.h_seven,
                    R.drawable.h_six,R.drawable.h_ten,R.drawable.h_three,R.drawable.h_two,R.drawable.d_a, R.drawable.d_eight, R.drawable.d_five,R.drawable.d_four,R.drawable.d_j,R.drawable.d_k,R.drawable.d_nine,R.drawable.d_q,R.drawable.d_seven,
                    R.drawable.d_six,R.drawable.d_ten,R.drawable.d_three,R.drawable.d_two, R.drawable.free};
    List<Integer> imagesArrayList = new ArrayList<Integer>(Arrays.asList(mImageIds));
    private ImageView gamecards;
    private ImageView back,arrow;
    private TextView rule;
    private static final Random rgenerator = new Random();
    private Animation bounce,zoom,zoom_in;
    private Button play_again;
    final int SHUFFLE_DELAY = 2000;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.beergame_activity, container, false);
        play = (TextView)rootView.findViewById(R.id.playText);
        arrow = (ImageView)rootView.findViewById(R.id.arrow);
        back = (ImageView)rootView.findViewById(R.id.back);
        rule = (TextView)rootView.findViewById(R.id.rule);
        gamecards = (ImageView)rootView.findViewById(R.id.gamecards);
        play_again = (Button)rootView.findViewById(R.id.play_again);
        rule.setVisibility(View.INVISIBLE);
        arrow.setVisibility(View.INVISIBLE);
        gamecards.setVisibility(View.INVISIBLE);
        play_again.setVisibility(View.GONE);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        changeImageResource();
        bounce = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.bounce);
        zoom = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.zoom_out);
        zoom_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.zoom_in);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/font.ttf");
        play.setTypeface(tf);
        rule.setTypeface(tf);
        play_again.setTypeface(tf);

        back.setOnClickListener(this);
        gamecards.setOnClickListener(this);
        play_again.setOnClickListener(this);




        return rootView;


    }
    public void onClick(View v) {
        if (v == back){
            back.setVisibility(View.GONE);
            play.setVisibility(View.GONE);
            rule.setVisibility(View.VISIBLE);
            rule.startAnimation(bounce);
            arrow.setVisibility(View.VISIBLE);
            arrow.startAnimation(bounce);
            gamecards.setVisibility(View.VISIBLE);
            gamecards.startAnimation(bounce);
            SoundManager.start(R.raw.swoosh, getActivity());
        } else if (v == gamecards){
            changeImageResource();
            if(imagesArrayList.size() != 0){
                gamecards.startAnimation(bounce);
                SoundManager.start(R.raw.swoosh, getActivity());
            } else if(imagesArrayList.size() == 0){
                SoundManager.start(R.raw.can, getActivity());
                play_again.setVisibility(View.VISIBLE);
            }
    } else if (v == play_again){
            Toast.makeText(getActivity(), "Shuffling cards", Toast.LENGTH_LONG).show();
            gamecards.startAnimation(zoom);
            play_again.setVisibility(View.GONE);
            SoundManager.start(R.raw.shuffle, getActivity());
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    imagesArrayList = new ArrayList<Integer>(Arrays.asList(mImageIds));
                    gamecards.setVisibility(View.GONE);
                    back.setVisibility(View.VISIBLE);
                }}, SHUFFLE_DELAY);
        }
    }
    public void changeImageResource()
    {

        if(imagesArrayList.size() != 0){
            int i = rgenerator.nextInt(imagesArrayList.size());
            gamecards.setImageResource(imagesArrayList.get(i));

            // remove image
            imagesArrayList.remove(i);
        } else {
        }
    }
}

