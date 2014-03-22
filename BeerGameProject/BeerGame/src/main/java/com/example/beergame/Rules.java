package com.example.beergame;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class Rules extends Fragment {
private ExpandableListView rule;
    private TextView rules,click;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rules_activity, container, false);
        rule = (ExpandableListView)rootView.findViewById(R.id.rulesList);
        rules = (TextView)rootView.findViewById(R.id.rules);
        click = (TextView)rootView.findViewById(R.id.click);
        final RuleListAdapter ruleListAdapter = new RuleListAdapter(this.getActivity());
        rule.setAdapter(ruleListAdapter);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/font.ttf");
        rules.setTypeface(tf);
        click.setTypeface(tf);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        return rootView;

    }
}