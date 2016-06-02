package com.khan.shakaib.findinghitler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.regex.PatternSyntaxException;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainPage extends Activity {
    @Bind(R.id.findHitlerBtn) Button findHitlerBtn;
    @Bind(R.id.loadingDisplay) ProgressBar mSpinner;
    @Bind(R.id.retryConnectionText) TextView mretryConnectionText;
    @Bind(R.id.retryConnectionBtn) Button mretryConnectionBtn;
    private String possibleLinks = null;
    private GetHTML htmlGetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ButterKnife.bind(this);
        loadContent(findViewById(android.R.id.content));

    }

    public void loadContent(View view){
        if(isThereNewtworkConnection()){
            mSpinner.setVisibility(View.VISIBLE);
            findHitlerBtn.setVisibility(View.GONE);
            mretryConnectionText.setVisibility(View.GONE);
            mretryConnectionBtn.setVisibility(View.GONE);
            try{
                if(possibleLinks == null){
                    possibleLinks = "https://en.wikipedia.org/wiki/Where%27s_Wally%3F";
                    htmlGetter = new GetHTML(possibleLinks);
                    htmlGetter.start();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            String oldURL = possibleLinks;
                            if(!htmlGetter.getURL().equals(oldURL)){
                                possibleLinks = htmlGetter.getURL();
                                Log.i("html2", possibleLinks);
                                mSpinner.setVisibility(View.GONE);
                                findHitlerBtn.setVisibility(View.VISIBLE);
                            }
                            else{

                                mSpinner.setVisibility(View.GONE);
                                mretryConnectionText.setVisibility(View.VISIBLE);
                                mretryConnectionBtn.setVisibility(View.VISIBLE);
                            }
                        }
                    }, 8000);

                }
            }catch(Exception e){
                mSpinner.setVisibility(View.GONE);
                mretryConnectionText.setVisibility(View.VISIBLE);
                mretryConnectionBtn.setVisibility(View.VISIBLE);
            }
        }else{
            findHitlerBtn.setVisibility(View.GONE);
            mretryConnectionText.setVisibility(View.VISIBLE);
            mretryConnectionBtn.setVisibility(View.VISIBLE);
        }

    }
    private boolean isThereNewtworkConnection(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void findHitler(View view) throws IOException{
        Intent open = new Intent(MainPage.this, FindingHitlerWebActivity.class);
        open.putExtra("url",possibleLinks);
        startActivity(open);
    }

    private class GetHTML extends Thread{
        private String changingURL = "";
        private Thread htmlGetting;

        public GetHTML(String url){
            this.changingURL = url;
        }

        public String getURL(){
            return this.changingURL;
        }

        public void run() {
            String message = "";
            String foundURL = this.changingURL;
            URL url;
            HttpURLConnection urlConnection = null;
            for(int i = 0; i < 5; i++){
                try {
                    url = new URL(foundURL);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);

                    int data = isr.read();
                    int hrefs = 0;

                    String check = "";
                    Boolean isBody = false;
                    while (data != -1) {
                        char current = (char) data;
                        data = isr.read();
                        if (isBody) {
                            message += current;
                        } else {
                            check += current;
                            if (check.contains("<body")) {
                                isBody = true;
                            }
                        }
                        if (message.contains("<a href=\"/wiki/") && message.contains("</a>")) {
                            hrefs++;
                            message = message.replace("<a", "~");
                            message = message.replace("</a>", "~");
                            if (hrefs == 10) {
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    Log.i("html", e.getMessage());
                }

                try {
                    urlConnection.disconnect();
                } catch (NullPointerException e) {
                }
                try{
                    message = findHrefs(message.split("\\s+")).replace("href=","");
                }catch(Exception e){
                    message ="";
                }

                Log.i("html0", message);
                message = message.replaceAll("\"","");
                message = "https://en.wikipedia.org"+message;
                foundURL = message;
            }


            Message msg = Message.obtain();
            msg.obj = message;
            messageHandler.sendMessage(msg);
        }

        public void start(){
            htmlGetting = new Thread(this);
            htmlGetting.start();
        }

        private Handler messageHandler = new Handler(){
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                try{
                    changingURL = msg.obj.toString();
                    Log.i("html1", changingURL);
                }catch(PatternSyntaxException ex){}
            }
        };

        public String findHrefs(String[] html){
            String[] hrefs  = new String[10];
            int hrefIndex = 0;
            for(int i =0; i<html.length; i++){
                if(hrefIndex >= 10){
                    break;
                }
                if(html[i].contains("href") && html[i].contains("/wiki/") && !html[i].contains("Special:MobileMenu") && !html[i].contains(".jpg") && !html[i].contains("wiktionary.org")){
                    hrefs[hrefIndex] = html[i];
                    hrefIndex++;
                }
            }
            int randomIndex = new Random().nextInt(hrefs.length);
            return hrefs[randomIndex];
        }
    }



}


