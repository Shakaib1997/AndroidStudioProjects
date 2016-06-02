package lab0_202_04.uwaterloo.ca.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = new TextView(this);
        tv.setText("Hello, World!");
        setContentView(tv);
    }
}


