package com.example.derekdesktop.assign22017derekaherne;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.EditText;
import android.util.Log;
import java.io.File;
import java.lang.String;

//https://developer.android.com/guide/components/intents-common.html
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String to = intent.getStringExtra(composeEmailActivity.TO_FIELD);
        String subject = intent.getStringExtra(composeEmailActivity.SUB_FIELD);
        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.outputView);
        if (to==null && subject==null) textView.setText(" "); else textView.setText(to+"\n"+subject);
    }

    public void onClickCam (View v){

        Intent camIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        startActivity(camIntent);
    }
        public void onClickGallery (View v){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(galleryIntent);
    }

    public void onClickActivity(View v) {
        Intent intent = new Intent(this, composeEmailActivity.class);
        startActivity(intent);
    }
   // https://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
    public void onSend (View v) {
        Intent intent = getIntent();
        String to = intent.getStringExtra(composeEmailActivity.TO_FIELD);
        String subject = intent.getStringExtra(composeEmailActivity.SUB_FIELD);

        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setType("message/rfc822");
        i.setData(Uri.parse("mailto:"+to));
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        startActivity(Intent.createChooser(i, "Send mail..."));
    }



}
