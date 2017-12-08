package com.tuv01.thanks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonOpen=(Button)findViewById(R.id.buttonOpen);

        //If click on the button, then redirect to Udacity
        buttonOpen.setOnClickListener(new View.OnClickListener() //if click on 
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,Udacity.class);
                startActivity(intent); //Start
            }
        });
    }



}
