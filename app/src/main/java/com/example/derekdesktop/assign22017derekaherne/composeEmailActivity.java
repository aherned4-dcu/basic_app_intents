package com.example.derekdesktop.assign22017derekaherne;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class composeEmailActivity extends AppCompatActivity {
    /** Citation: Class contains code adapted from
     * URL: https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
     * Permission: MIT Licence Retrieved on:1Oth November 2017  */

    public static final String TAG = composeEmailActivity.class.getSimpleName(); //Log tag

    public static final String TO_FIELD = "TO";
    public static final String SUB_FIELD = "SUBJECT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* code adapted from post described at
            https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_email);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // give me a back button
        Log.i(TAG,"inside on create method");
    }

    public void onClick (View v){
        //extract text from EditText fields
        Intent homeIntent = new Intent(this, MainActivity.class);
        EditText editTextTo = (EditText) findViewById(R.id.textViewTo);
        EditText editTextSubject = (EditText) findViewById(R.id.textViewSub);
        //store in variables
        String to = editTextTo.getText().toString();
        String subject = editTextSubject.getText().toString();
        // concatenates and make varaiables available
        homeIntent.putExtra(TO_FIELD, "To: "+to);
        homeIntent.putExtra(SUB_FIELD, "Subject: "+subject);
        startActivity(homeIntent);
        Log.i(TAG," inside onClick - send button pressed");
    }

}
