package com.example.shreykavi.homework1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private TextView texti;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texti = (TextView) findViewById(R.id.text);
        this.gestureDetector = new GestureDetectorCompat(this, this);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(
                new Button.OnClickListener() {;
                    public void onClick(View v) {
                        texti.setText("button clicked");
                    }
                }
        );

        button.setOnLongClickListener(
                new Button.OnLongClickListener(){;
                    public boolean onLongClick(View v) {
                        texti.setText("Long clicked");
                        return true;
                    }
                }
        );
    }


    /////////////////////START GESTURES////////////////////////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        texti.setText("");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        texti.setText("");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        texti.setText("");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        texti.setText("");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        texti.setText("");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        texti.setText("");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        texti.setText("Get Flung");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        texti.setText("");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        texti.setText("Fling Thing ;p");
        return true;
    }
    ////////////////////END GESTURES////////////////////////

    @Override
    public boolean onTouchEvent(MotionEvent event) { //default when screen touched
        this.gestureDetector.onTouchEvent(event); //detects if special gesture
        return super.onTouchEvent(event); //continues on code
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
