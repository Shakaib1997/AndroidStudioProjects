package com.learning.shakaib.messenger;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReceiveMessageActivity extends Activity {
    @Bind(R.id.message) TextView messageView;
    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        ButterKnife.bind(this);
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        messageView.setText(messageText);
    }
}


