package com.example.clear.lab1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText editText;

    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        editText = (EditText) findViewById(R.id.editText);

        /* #4-2
        * Add a login button to the LoginActivity, and store a reference to the button in the Java Activity.
        */
        Button loginBt = (Button) findViewById(R.id.button2); // reference

        /* #4-3
        * Create a callback function for the login button so that it stores the text
        * in the login email field to the Shared Preferences of your application.
        * Don’t forget to commit the changes!
        * Next, call startActivity() with your Lab1 StartActivity as the next Activity to start:
        * Intent intent = new Intent(LoginActivity.this, StartActivity.class);
        * startActivity(intent);
        */
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = getSharedPreferences("email", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("DefaultEmail", editText.getText().toString());
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent); // explicitly defines the activity you want to start, using the class name

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.i(ACTIVITY_NAME, "In onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(ACTIVITY_NAME, "In onResume()");

    }

    @Override
    protected void onStart() {

        super.onStart();

        Log.i(ACTIVITY_NAME, "In onStart()");

        /* #4-3
         * Modify the onStart() function to read the value of the stored email address
         * in SharedPreferences and sets the initial text of the login email field.
         * The first time you run your application and read from the preferences,
         * the value saved under your email string will be missing,
         * so your sharedPreferences.getString(“DefaultEmail”, “email@domain.com”)
         * call will make use of the default value parameter (2nd parameter).
         */
        SharedPreferences sharedPreferences = getSharedPreferences("email", MODE_PRIVATE);
        String defaultValue = sharedPreferences.getString("DefaultEmail","happy@domain.com");
        editText.setText(defaultValue);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(ACTIVITY_NAME, "In onPause()");


    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(ACTIVITY_NAME, "In onStop()");
    }

}
