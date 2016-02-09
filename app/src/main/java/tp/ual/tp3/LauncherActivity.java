package tp.ual.tp3;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tp.ual.tp3.data.Mail;
import tp.ual.tp3.data.MailAdapter;

public class LauncherActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {

/**
 * 1 - Add a ListView to the LauncherActivity to display the mails list (From + Subject) from Mail class
 * 2 - Manage the click action on the list to display the details (From + Subject + Message) of the selected mail in a second Activity
 * 3 - Modify LauncherView so when it is in Landscape, it can directly display in its own Layout the detail of the selected mail
 * 4 - When the application has its orientation changed it has to display the last selected mail
 */

    private int currentMailIndex;
    DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        if(savedInstanceState != null) {
            currentMailIndex = savedInstanceState.getInt("currentIndex",0);
        }

        MailAdapter adapter = new MailAdapter(this, Mail.getList());

        // Attach the adapter to ou list view
        ListView mailListView = (ListView) findViewById(R.id.list_mail);
        mailListView.setAdapter(adapter);

        if (findViewById(R.id.fragment_detail) != null) {
            handleFragement();
        }

        mailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentMailIndex = position;
                if (findViewById(R.id.fragment_detail) != null) {
                    handleFragement();
                } else {
                    Intent viewDetailIntent = new Intent(LauncherActivity.this, DetailActivity.class);
                    viewDetailIntent.putExtra(DetailFragment.MAIL_INDEX, currentMailIndex);
                    startActivity(viewDetailIntent);
                }
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt("currentIndex", currentMailIndex);

        super.onSaveInstanceState(outState);
    }

    private void handleFragement() {
        // Create fragment
        detailFragment = DetailFragment.newInstance(currentMailIndex);

        // Execute a transaction, replacing any existing fragment
        // with this one inside the frame.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_detail, detailFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
