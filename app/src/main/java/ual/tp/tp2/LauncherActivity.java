package ual.tp.tp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LauncherActivity extends AppCompatActivity {

    /**
     * TP2
     * 1 - Display the date and update it each second (100ms precision) using a simple Thread, but only when the app is front. Display the number of update iteration below.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }
}
