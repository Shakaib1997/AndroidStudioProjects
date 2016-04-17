package com.khan.shakaib.findinghitler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FindingHitlerWebActivity extends AppCompatActivity {
    @Bind(R.id.hitlerWebView) WebView hitlersWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_hitler_web);
        ButterKnife.bind(this);

    }

}
