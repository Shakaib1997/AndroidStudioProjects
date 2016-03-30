package com.example.shreykavi.allisoninterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout; //import for layout, can be different types of layouts
import android.widget.Button; //import for button
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //layout
        RelativeLayout shreysLayout = new RelativeLayout(this); //declaring new layout(relative)
        shreysLayout.setBackgroundColor(Color.GRAY); // set color

        //set location to center:

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams( //button
        // size
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        ); // Automatic parameters for height and width of content

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //button
        Button whiteButton = new Button(this); //declaring new button(widget)
        whiteButton.setText("Log in");
        whiteButton.setBackgroundColor(Color.WHITE);
        whiteButton.setId(1); //set ID

        //adding button to layout and second part tells how to add it
        shreysLayout.addView(whiteButton, buttonDetails);

        //sets layout to be display
        setContentView(shreysLayout);

        //username input
        EditText userName = new EditText(this);
        userName.setId(2);

        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams( //button
                // size
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        userNameDetails.addRule(RelativeLayout.ABOVE, whiteButton.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0, 0, 0, 50);

        shreysLayout.addView(userName, userNameDetails);
        //give position

        Resources r = getResources(); //gets info about app
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,
                r.getDisplayMetrics();
                ); // sets px to amount of pixels in 200 DIP so its the same size on any device

        userName.setWidth(px);

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
