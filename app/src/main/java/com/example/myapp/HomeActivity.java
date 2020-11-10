package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       /* getting intent from this activity*/
        Intent intent = getIntent();
       /* getting extras from intent*/
        Bundle extras = intent.getExtras();
        if(extras!= null) {
            /* from extras get the string with key = mykey*/
            String data = extras.getString("mykey");
            /* put string extracted into textview*/
            TextView resultsTextView = findViewById(R.id.textView);
            resultsTextView.setText(data);
            Log.w(TAG, "onCreate");
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onstop");
    }

}