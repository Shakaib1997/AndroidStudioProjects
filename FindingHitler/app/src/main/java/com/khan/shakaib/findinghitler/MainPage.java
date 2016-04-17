package com.khan.shakaib.findinghitler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainPage extends Activity {
    @Bind(R.id.findHitlerBtn) Button findHitlerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ButterKnife.bind(this);
    }

    public void findHitler(){
        Intent open = new Intent(this, FindingHitlerWebActivity.class);

    }
}
