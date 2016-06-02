package com.khan.shakaib.findinghitler;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MyAppWebViewClient extends WebViewClient {
    private String previousUrl = "https://en.wikipedia.org/wiki/Where%27s_Wally%3Fs";
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url){
        if(url.contains("wikipedia.org") && !url.contains("=toggle_view_desktop"))
        {
            this.previousUrl = url;
            view.loadUrl(url);
            return true;
        }
        else
        {
            view.loadUrl(this.previousUrl);
            if(url.contains("=toggle_view_desktop")){
                Toast.makeText(view.getContext(), "Stay on the mobile view please",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(view.getContext(), "Stay on Wikipedia!",Toast.LENGTH_LONG).show();
            }

        }
        return false;
    }

}
