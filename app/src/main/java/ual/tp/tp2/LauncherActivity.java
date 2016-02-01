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

    static final String COUNT_INC = "count_increment";

    TextView dateLabel;
    TextView countLabel;
    Thread timer;
    long count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        if (savedInstanceState != null) {
            count = savedInstanceState.getLong(COUNT_INC);
        } else {
            count = 0;
        }

        dateLabel = (TextView) findViewById(R.id.date);
        countLabel = (TextView) findViewById(R.id.count);
        countLabel.setText(count + "");
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

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putLong(COUNT_INC, count);

        //!!!Call at END!!!
        super.onSaveInstanceState(outState);
    }
}