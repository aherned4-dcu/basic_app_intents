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


public class MainActivity extends AppCompatActivity {
    /** Citation: Class contains code adapted from
     * URL: https://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
     * Permission: MIT Licence Retrieved on:1Oth November 2017  */

    /** Citation: Class contains code adapted from
     * URL: //https://developer.android.com/guide/components/intents-common.html
     * Permission: http://www.apache.org/licenses/LICENSE-2.0 Retrieved on:1Oth November 2017  */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //disable the action bar on home screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //declare new intent to extract email fields if any
        Intent intent = getIntent();
        String to = intent.getStringExtra(composeEmailActivity.TO_FIELD); //email recipient
        String subject = intent.getStringExtra(composeEmailActivity.SUB_FIELD); //subject of email
        // Capture the layout's TextView and set the email firelds as its text
        TextView textView = (TextView) findViewById(R.id.outputView);
        // If the text exists then set it to the text view
        if (to==null && subject==null) textView.setText(" "); else textView.setText(to+"\n"+subject);
    }



    public void onClickCam (View v){
        /* open camera in still mode/* code adapted from tutorial described at
        * URL: //https://developer.android.com/guide/components/intents-common.html
        */
        // open camera in still mode
        Intent camIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        startActivity(camIntent);
    }
        public void onClickGallery (View v){
        /* code adapted from tutorial described at
        * URL: //https://developer.android.com/guide/components/intents-common.html
        */
        //open gallery
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(galleryIntent);
    }

    public void onClickActivity(View v) {
        //open another activity explicitly
        Intent intent = new Intent(this, composeEmailActivity.class);
        startActivity(intent);
    }

    public void onSend (View v) {
         /* code adapted from post described at
            https://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
         */
        Intent intent = getIntent();
        String to = intent.getStringExtra(composeEmailActivity.TO_FIELD);
        String subject = intent.getStringExtra(composeEmailActivity.SUB_FIELD);

        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setType("message/rfc822"); // ensure only email apps
        i.setData(Uri.parse("mailto:"+to)); //recipient
        i.putExtra(Intent.EXTRA_SUBJECT, subject); //subject
        startActivity(Intent.createChooser(i, "Send mail..."));
    }



}
