package com.example.shreykavi.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bottomfragment extends Fragment {

    private static TextView topMemeTextP;
    private static TextView bottomMemeTextP;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.bottomfragment, container, false);
        topMemeTextP = (TextView)view.findViewById(R.id.topMText);
        bottomMemeTextP = (TextView)view.findViewById(R.id.bottomMText);
        return view;
    }

    public void setMText(String top, String bottom){
        topMemeTextP.setText(top);
        bottomMemeTextP.setText(bottom);
    }

}
