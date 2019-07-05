package com.example.firebaseconnection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NamesAdapter extends ArrayAdapter<name> {


    public NamesAdapter(Context context, ArrayList<name> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(getContext());
        View v = convertView;
        if(v == null)
            v = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        name n = getItem(position);
        String Name = n.getN();
        TextView textView = (TextView) v.findViewById(android.R.id.text1);
        textView.setText(Name);
        return v;
    }
}
