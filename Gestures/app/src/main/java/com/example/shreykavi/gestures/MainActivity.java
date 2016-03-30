package com.example.shreykavi.gestures;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements  GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private  TextView shreysMessage;
    private GestureDetectorCompat gestureDetector; //object from dectecting class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shreysMessage = (TextView)findViewById(R.id.shreysMessage);
        this.gestureDetector = new GestureDetectorCompat(this,this); //new object of detecting class
        //this above refers to current object
        
    }


/////////////////////START GESTURES////////////////////////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        shreysMessage.setText("Single Tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        shreysMessage.setText("Double Tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        shreysMessage.setText("Single Tap");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        shreysMessage.setText("Hold Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        shreysMessage.setText("SHOW PRESSES");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        shreysMessage.setText("TAP UP");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        shreysMessage.setText("That tickles");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        shreysMessage.setText("HOLD DOWN");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        shreysMessage.setText("Fling Thing ;p");
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
