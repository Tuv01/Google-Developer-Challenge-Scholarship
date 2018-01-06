package com.tuv01.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    private String enteredusername;
    private EditText username;
    private Button buttonlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //EditText
        username=(EditText)findViewById(R.id.username);
        //Button Login
        buttonlogin=(Button)findViewById(R.id.login);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If click on the button Login
                enteredusername = username.getText().toString(); //username value entered by the user
                if (enteredusername.equals("")) {
                    Toast.makeText(Login.this, R.string.messagefilllogin, Toast.LENGTH_LONG).show();
                    //Error msg if username is equals " "
                } else {
                    change();
                }
            }});
    }

    public void change()
    {
        Intent intent=new Intent(Login.this,MainActivity.class);
        SharedPreferences.Editor editor = getSharedPreferences("your_pref_name", MODE_PRIVATE).edit();
        editor.putString("username",enteredusername);
        editor.commit();
        startActivity(intent);
    }
}

