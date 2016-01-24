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
     * 1 - Add a button to the LauncherActivity and change the "Hello world" message by the current date
     * 2 - Create a second Activity WriteActivity that contains a text field and a send button
     * 3 - Connect the button action to start the new WriteActivity
     * 4 - Make the WriteActivity validation button send a implicit Intent to share the text input
     * 5 - Create a new contact with a mail and configure your application so WriteActivity will be called if you try to send a mail from the contact app
     * 6 - Set a BroadcastReceiver to update the current time every minute
     * 7 - Set another BroadcastReceiver to display a notification when the Airplane mode is activated
     * 8 - Add a "Attach a photo" functionality. Don't try to send text and image at the same time though
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        TextView infoDate = (TextView) findViewById(R.id.info_date);
        infoDate.setText((new SimpleDateFormat("dd MM yyyy")).format(new Date()));

        Button actionWrite = (Button) findViewById(R.id.button_write);
        actionWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToWriteActivity = new Intent(LauncherActivity.this, WriteActivity.class);
                startActivity(goToWriteActivity);
            }
        });
    }

}
