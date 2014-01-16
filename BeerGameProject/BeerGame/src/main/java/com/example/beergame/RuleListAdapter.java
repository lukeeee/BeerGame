package com.example.beergame;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class RuleListAdapter extends BaseExpandableListAdapter{
    private Activity context;
    private Map<String, ArrayList<String>> cardRule;
    private ArrayList<String> categories;

    public RuleListAdapter(Activity context) {
        this.context = context;

        categories = new ArrayList<String>();
        categories.add("2 ♣♠");
        categories.add("3 ♣♠");
        categories.add("4 ♣♠");
        categories.add("5 ♣♠");
        categories.add("2 ♥♦");
        categories.add("3 ♥♦");
        categories.add("4 ♥♦");
        categories.add("5 ♥♦");
        categories.add("6 ♥♦♣♠");
        categories.add("7 ♥♦♣♠");
        categories.add("8 ♥♦♣♠");
        categories.add("9 ♥♦♣♠");
        categories.add("10 ♥♦♣♠");
        categories.add("Jack's ♥♦♣♠");
        categories.add("Queen's ♥♦♣♠");
        categories.add("King's ♥♦♣♠");
        categories.add("Ace's ♥♦♣♠");

        cardRule = new LinkedHashMap<String, ArrayList<String>>();

        ArrayList<String> children = new ArrayList<String>();
        children.add("Clubs & Spades");
        children.add("The player who got this card have to Drink 2 sips");
        cardRule.put("2 ♣♠", children);

        children = new ArrayList<String>();
        children.add("Clubs & Spades");
        children.add("The player who got this card have to Drink 3 sips");
        cardRule.put("3 ♣♠", children);

        children = new ArrayList<String>();
        children.add("Clubs & Spades");
        children.add("The player who got this card have to Drink 4 sips");
        cardRule.put("4 ♣♠", children);

        children = new ArrayList<String>();
        children.add("Clubs & Spades");
        children.add("The player who got this card have to Drink 5 sips");
        cardRule.put("5 ♣♠", children);

        children = new ArrayList<String>();
        children.add("Hearts & Diamonds");
        children.add("The player who got this card get to hand out 2 sips");
        cardRule.put("2 ♥♦", children);

        children = new ArrayList<String>();
        children.add("Hearts & Diamonds");
        children.add("The player who got this card get to hand out 3 sips");
        cardRule.put("3 ♥♦", children);

        children = new ArrayList<String>();
        children.add("Hearts & Diamonds");
        children.add("The player who got this card get to hand out 4 sips");
        cardRule.put("4 ♥♦", children);

        children = new ArrayList<String>();
        children.add("Hearts & Diamonds");
        children.add("The player who got this card get to hand out 5 sips");
        cardRule.put("5 ♥♦", children);

        children = new ArrayList<String>();
        children.add("Empty Your Can");
        children.add("The player who got this card must drink all he/she has in the glass/can/bottle ");
        cardRule.put("6 ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("Toilet");
        children.add("The player who got this card can go to the bathroom when he/she wants");
        cardRule.put("7 ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("Thumbs");
        children.add("The player who got this card can place his thumb on the table when he/she" +
                " feels like it and the last person to place his thumb on the" +
                " table has to drink 3 sips");
        cardRule.put("8 ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("Theme");
        children.add("The player who got this card must say a theme that everybody must say" +
                " something in the theme like cars: volvo,ford, opel..." +
                " the first who can't say something must drink 3 sips");
        cardRule.put("9 ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("Rule");
        children.add("The player who got this card gets to add a new rule that the players must" +
                " do before or after they drink and if they forget it they" +
                " have to drink 3 sips, or it can be used to delete another rule");
        cardRule.put("10 ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("Rhyme");
        children.add("The player who got this card must rhyme - you say a word and" +
                " everybody must rhyme on it like donkey, monkey..." +
                " The first who say a word that has been said has to drink 3 sips ");
        cardRule.put("Jack's ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("All Ladies");
        children.add("All ladies must drink 3 sips");
        cardRule.put("Queen's ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("All Men");
        children.add("All men must drink 3 sips");
        cardRule.put("King's ♥♦♣♠", children);

        children = new ArrayList<String>();
        children.add("Waterfall");
        children.add("Everyone starts drinking at the same time," +
                " the player who got this card can stop when he/she wants," +
                " everyone else has to wait until the person before them stops in order to stop. ");
        cardRule.put("Ace's ♥♦♣♠", children);

    }


    public Object getChild(int groupPosition, int childPosition) {
        return cardRule.get(categories.get(groupPosition)).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String ingredientName = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rulelistchild, null);
        }

        TextView item = (TextView) convertView.findViewById(R.id.textView);
        item.setText(ingredientName);

        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return cardRule.get(categories.get(groupPosition)).size();
    }

    public Object getGroup(int groupPosition) {
        return categories.get(groupPosition);
    }

    public int getGroupCount() {
        return categories.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String laptopName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.rulelistparent,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.id.textView);
        item.setTypeface(null, Typeface.BOLD);

        item.setText(laptopName);


        return convertView;
    }


    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}