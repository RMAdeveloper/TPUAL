package ual.tp.tp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

public class LauncherActivity extends AppCompatActivity {

    /**
     * TP2
     * 1 - Display the date and update it each second (100ms precision) using a simple Thread, but only when the app is front. Display the number of update iteration below.
     * 2 - Override dedicated Activity methods to prevent information loss that can occur during its lifecycle
     * 3 - Refactor your timer computation in a Service
     */

    TextView dateLabel;
    TextView countLabel;
    Thread timer;
    long count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        dateLabel = (TextView) findViewById(R.id.date);
        countLabel = (TextView) findViewById(R.id.count);
        count = 0;

    }

    @Override
    protected void onResume() {
        super.onResume();

        timer = new Thread() {
            @Override
            public void run() {

                long before = System.currentTimeMillis();
                boolean stop = false;

                while (!stop) {
                    long now = System.currentTimeMillis();
                    count++;
                    if (now > before + 1000) {
                        before = now;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dateLabel.setText(new Date().toString());
                                countLabel.setText(count + "");

                            }
                        });
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        stop = true;
                    }
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.interrupt();
    }
}
