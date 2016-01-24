package ual.tp.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LauncherActivity extends AppCompatActivity {

    /**
     * TP1
     * 1 - Add a button to the LauncherActivity and change the "Hello world" message by the current time
     * 2 - Create a second Activity WriteActivity that contains a text field and a send button
     * 3 - Connect the button action to start the new WriteActivity
     * 4 - Make the WriteActivity validation button send a implicit Intent to share the text input
     * 5 - Create a new contact with a mail and configure your application so WriteActivity will be called if you try to send a mail from the contact app
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

}
