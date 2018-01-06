package com.tuv01.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        int result = 0;

        SharedPreferences prefs = getSharedPreferences("your_pref_name", MODE_PRIVATE);
        String username = prefs.getString("username", "");
        Bundle extras = getIntent().getExtras();
        TextView resultText = findViewById(R.id.result);
        result = extras.getInt("score");
        resultText.setText(username+" "+getResources().getString(R.string.yourscore)+" "+result+" "+getResources().getString(R.string.from)+" "+7);
        }
}


