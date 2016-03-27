package com.example.saif.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class MainActivity extends FragmentActivity {

    private PagerAdapter mPagerAdapter;
    private static ArrayList<String> questions;
    public static TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        initialisePaging();

    }

    private void initialisePaging(){
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this,QuestionFragment.class.getName()));
        fragments.add(Fragment.instantiate(this,QuestionFragment.class.getName()));
        fragments.add(Fragment.instantiate(this,QuestionFragment.class.getName()));
        mPagerAdapter = new PagerAdapter(this.getSupportFragmentManager(),fragments);

        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(mPagerAdapter);

    }


}
