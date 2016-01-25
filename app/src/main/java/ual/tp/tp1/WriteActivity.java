package ual.tp.tp1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import ual.tp.tp1.utils.PhotoTool;

public class WriteActivity extends AppCompatActivity {

    private int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView infoPhotoPreview;
    private EditText inputText;
    private Button actionSend;
    private Uri localUri;
    private Uri sharingUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        inputText = (EditText) findViewById(R.id.input_text);
        actionSend = (Button) findViewById(R.id.button_send);
        final Button attachPhoto = (Button) findViewById(R.id.button_attachPhoto);
        infoPhotoPreview = (ImageView) findViewById(R.id.info_photoPreview);

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
                public void onClick(View v) {
                    Intent implicitSendMessage = new Intent(Intent.ACTION_SEND);
                    if(sharingUri != null) {
                        implicitSendMessage.setType("image/*");
                        implicitSendMessage.putExtra(Intent.EXTRA_STREAM, sharingUri);
                    } else {
                        implicitSendMessage.setType("text/plain");
                        implicitSendMessage.putExtra(Intent.EXTRA_TEXT, inputText.getText().toString());
                    }


                    //Verify the original intent will resolve to at least one activity
//                if (implicitSendMessage.resolveActivity(getPackageManager()) != null) {
//                    startActivity(implicitSendMessage);
//                }

                    //Or force application chooser to prevent ourselves the creation of missing compatible app message
                    String title = getResources().getString(R.string.action_send);
                    Intent chooser = Intent.createChooser(implicitSendMessage, title);
                    startActivity(chooser);
                }
            });

        attachPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    // Create the File where the photo should go
                    File photoFile = null;
                    try {
                        photoFile = PhotoTool.createImageFile();
                        localUri = Uri.fromFile(photoFile);
                    } catch (IOException ex) {
                        String message = ex.getMessage();
                    }
                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, localUri);
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap imageBitmap = BitmapFactory.decodeFile(localUri.getPath());
            infoPhotoPreview.setImageBitmap(imageBitmap);

            actionSend.setEnabled(true);

            MediaScannerConnection.scanFile(
                    getApplicationContext(),
                    new String[]{localUri.getPath()},
                    null,
                    new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                            WriteActivity.this.sharingUri=uri;
                        }

                    });

        }
    }
}
