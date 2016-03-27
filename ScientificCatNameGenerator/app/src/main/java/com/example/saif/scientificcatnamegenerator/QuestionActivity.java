package com.example.saif.scientificcatnamegenerator;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import butterknife.Bind;
import butterknife.ButterKnife;


public class QuestionActivity extends ActionBarActivity {
    private PagerAdapter mPagerAdapter;
    private static ArrayList<String> questions;
    public static final int NUMBER_OF_QUESTIONS = 15;


    private String name;

    private Context context;
    private int[] answerArray = new int[15];
    int questionNumber = 0;

    private QuestionHandler questionGetter;
    private AnswerHandler answerGetter;



    @Bind(R.id.back_button) Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_);
        ButterKnife.bind(this);

        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(QuestionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        /// HERE IS WHERE WE START THE VIEWPAGER
        initialisePaging();


    }

    private void initialisePaging(){
        List<Fragment> fragments = new Vector<Fragment>();
        for(int i=0;i<NUMBER_OF_QUESTIONS;i++){
            fragments.add(Fragment.instantiate(this,QuestionFragment.class.getName()));
        }

        mPagerAdapter = new QuestionPagerAdapter(this.getSupportFragmentManager(),fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.questionViewPager);


        pager.setAdapter(mPagerAdapter);

    }

    }


