package com.example.derekdesktop.assign22017derekaherne;

import android.provider.MediaStore;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.app.ActionBar;
import android.view.MenuItem;

public class composeEmailActivity extends AppCompatActivity {

    public static final String TO_FIELD = "TO";
    public static final String SUB_FIELD = "SUBJECT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

       // https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_email);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick (View v){

        Intent homeIntent = new Intent(this, MainActivity.class);
        EditText editTextTo = (EditText) findViewById(R.id.textViewTo);
        EditText editTextSubject = (EditText) findViewById(R.id.textViewSub);
        String to = editTextTo.getText().toString();
        String subject = editTextSubject.getText().toString();
        homeIntent.putExtra(TO_FIELD, "To: "+to);
        homeIntent.putExtra(SUB_FIELD, "Subject: "+subject);
        startActivity(homeIntent);
    }

    // https://stackoverflow.com/questions/14545139/android-back-button-in-the-title-bar
    /*public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }*/
}
