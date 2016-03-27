package com.example.saif.viewpagerexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionFragment extends Fragment {

    private static ArrayList<String> questions;
    public TextView questionText;
    private int mPosition = 0;

    public static QuestionFragment instance(int position) {
        QuestionFragment fragment1 = new QuestionFragment();
        fragment1.setPosition(position);
        return fragment1;
    }

    public void setPosition(int position) {
        mPosition = position;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        questions = new ArrayList<String>();
        questions.add("q1 at position" + mPosition);
        questions.add("q2");
        if(container == null){
            return null;
        }
        View v =(LinearLayout)inflater.inflate(R.layout.fragment_layout, container, false);
        questionText = (TextView)v.findViewById(R.id.textView);
        questionText.setText("this is question page " + mPosition);
        return v;
    }

//    public static void setQuestion(int questionNumber){
//        questionText.setText(questions.get(questionNumber));
//    }
}
