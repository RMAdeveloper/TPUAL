package ual.tp.tp1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        final EditText inputText = (EditText) findViewById(R.id.input_text);
        final Button actionSend = (Button) findViewById(R.id.button_send);

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    actionSend.setEnabled(s.length() > 0);
            }

                @Override
                public void afterTextChanged (Editable s){

                }
            });

            actionSend.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                Intent implicitSendMessage = new Intent(Intent.ACTION_SEND);
                implicitSendMessage.setType("text/plain");
                implicitSendMessage.putExtra(Intent.EXTRA_TEXT, inputText.getText().toString());

                //Verify the original intent will resolve to at least one activity
//                if (implicitSendMessage.resolveActivity(getPackageManager()) != null) {
//                    startActivity(implicitSendMessage);
//                }

                //Or force application chooser to prevent ourselves the creation of a message
                String title = getResources().getString(R.string.action_send);
                Intent chooser = Intent.createChooser(implicitSendMessage, title);
                startActivity(chooser);
            }
            });
    }
}
