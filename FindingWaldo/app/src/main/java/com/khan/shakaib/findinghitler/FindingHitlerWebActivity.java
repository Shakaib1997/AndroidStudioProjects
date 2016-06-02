package com.khan.shakaib.findinghitler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;


public class FindingHitlerWebActivity extends Activity {
    private WebView hitlersWeb;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_hitler_web);

        Bundle bundle = getIntent().getExtras();
        this.url = bundle.getString("url");

        Toast.makeText(getApplicationContext(), "Click links to try to get to Waldo's page",Toast.LENGTH_LONG).show();

        hitlersWeb = (WebView) findViewById(R.id.hitlerWebView);
        hitlersWeb.setWebViewClient(new WebViewClient());

        WebSettings webSettings = hitlersWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        hitlersWeb.loadUrl(this.url);
        hitlersWeb.setWebViewClient(new MyAppWebViewClient());

    }

}
