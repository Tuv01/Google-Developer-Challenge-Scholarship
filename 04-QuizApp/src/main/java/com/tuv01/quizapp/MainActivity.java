package com.tuv01.quizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

   private final int total=7;
   private int score;
   protected RadioButton iqLösung[] = new RadioButton[5];
   protected EditText answer;
   protected String enteredanswers; //To save the answer value entered by the user
   protected CheckBox checkbox7_1;
   protected CheckBox checkbox7_2;
   protected CheckBox checkbox7_3;
   protected CheckBox checkbox7_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Answers:
        //RadioButton
        iqLösung[0] = (findViewById(R.id.answer1_4)); //25
        iqLösung[1] = (findViewById(R.id.answer2_4)); //48
        iqLösung[2] = (findViewById(R.id.answer3_4)); //1600
        iqLösung[3] = (findViewById(R.id.answer4_2)); //24
        iqLösung[4] = (findViewById(R.id.answer5_4)); //d
        //EditText
        answer=(EditText)findViewById(R.id.answer6); //c
        //CheckBox
        checkbox7_1 = findViewById(R.id.answer7_1); //3
        checkbox7_2 = findViewById(R.id.answer7_2); //7
        checkbox7_3 = findViewById(R.id.answer7_3); //8 not
        checkbox7_4 = findViewById(R.id.answer7_4); //15

    }


    /**
     * This method checks if the user have the correct radioButton selected and updates the user`s score.
     */
    public void checkIqLösung() {
        for (int i = 0; i < iqLösung.length; i++) {
            RadioButton radioButton = iqLösung[i];
            if (radioButton.isChecked()) {
                score++;
            }
        }
    }
    /**
     * This method checks if the user have the correct Checkbox selected and updates the user's score.
     */
    public void checkIqCheckbox()
    {

        if ((checkbox7_1.isChecked() && checkbox7_2.isChecked()
                && checkbox7_4.isChecked()) && (!checkbox7_3.isChecked())) {
            score++;

        }
    }

    /**
     * This method checks if the user have the correct answer inserted and updates the user's score.
     */
    public void checkIqText()
    {
        enteredanswers = answer.getText().toString(); //answer value entered by the user
        enteredanswers.toLowerCase();

        if(enteredanswers.equals("c"))
        {
            score++;
        }
    }
    /**
     * This method returns the final score.
     */
    private int calculateScore() {
        score=0;
        checkIqLösung(); //RadioButton score checks and update
        checkIqCheckbox(); //Checkbox score checks and update
        checkIqText(); //EditText score checks and update
        return score;
    }

    /**
     * This method is called when the submit answers button is clicked.
     */
    public void showResult (View view){
        int result = calculateScore();
        customToast(result);
    }

    /**
     * This method is called when the submit answers button is clicked and shows 2 different custom Toast message
     * @param result
     */
    public void customToast(int result)
    {
        if (result<7)
        {

            //Toast with image
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast2,
                    (ViewGroup) findViewById(R.id.custom_toast_container));
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
            new Handler().postDelayed(new Runnable () {
                @Override
                public void run() {
                    //Intent to End (custom gif)
                    Intent intent=new Intent(MainActivity.this,EndScreen.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                }
            },2000); //2 seconds


        }

        else {

            //Toast with image
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast,
                    (ViewGroup) findViewById(R.id.custom_toast_container2));
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
            new Handler().postDelayed(new Runnable () {
                @Override
                public void run() {

                    //Intent to End (custom gif)
                    Intent intent=new Intent(MainActivity.this,EndScreen.class);
                    intent.putExtra("score",score);
                    startActivity(intent);

                }
            },2000); //2 seconds


        }
    }






}
