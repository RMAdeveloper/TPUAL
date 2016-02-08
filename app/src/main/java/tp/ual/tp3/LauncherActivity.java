package tp.ual.tp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LauncherActivity extends AppCompatActivity {

    /**
     * 1 - Add a ListView to the LauncherActivity to display the mails list (From + Subject) from Mail class
     * 2 - Manage the click action on the list to display the details (From + Subject + Message) of the selected mail in a second Activity
     * 3 - Modify LauncherView so when it is in Landscape, it can directly display in its own Layout the detail of the selected mail
     * 4 - When the application has its orientation changed it has to display the last selected mail
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }
}
