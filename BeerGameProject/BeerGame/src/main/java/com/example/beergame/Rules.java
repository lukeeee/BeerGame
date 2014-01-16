package com.example.beergame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;


public class Rules extends Activity {
private ExpandableListView rule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_activity);
        rule = (ExpandableListView)findViewById(R.id.rulesList);
        final RuleListAdapter ruleListAdapter = new RuleListAdapter(this);
        rule.setAdapter(ruleListAdapter);
        getActionBar().setDisplayHomeAsUpEnabled(true);



    }
}