package com.example.beergame;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class About extends Fragment {
TextView madeby,about,abouttext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.about_activity, container, false);
        about = (TextView)rootView.findViewById(R.id.about);
        abouttext = (TextView)rootView.findViewById(R.id.about_text);
        madeby = (TextView)rootView.findViewById(R.id.madeby);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/font.ttf");

        abouttext.setTypeface(tf);
        about.setTypeface(tf);
        madeby.setTypeface(tf);


        return rootView;
    }
}

