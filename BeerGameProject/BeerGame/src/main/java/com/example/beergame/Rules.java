package com.example.beergame;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


public class Rules extends Fragment {
private ExpandableListView rule;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rules_activity, container, false);
        rule = (ExpandableListView)rootView.findViewById(R.id.rulesList);
        final RuleListAdapter ruleListAdapter = new RuleListAdapter(this.getActivity());
        rule.setAdapter(ruleListAdapter);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        return rootView;

    }
}