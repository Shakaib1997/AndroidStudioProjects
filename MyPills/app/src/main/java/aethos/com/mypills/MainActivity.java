package aethos.com.mypills;

import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "";
    public static String DEVICE_ADDRESS = "dont know for now";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
