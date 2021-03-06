package com.example.saif.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;
    public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position){
        Fragment fragment = QuestionFragment.instance(position);
        return fragment;
    }

    @Override
    public int getCount(){
        return 3;
    }
}
