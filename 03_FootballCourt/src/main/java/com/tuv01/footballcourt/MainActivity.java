package com.tuv01.footballcourt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity keeps track of the football score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {
    //Counter for A
    int counterA=0;
    //Counter for B
    int counterB=0;
    // Tracks the score for Team A
    int scoreTeamA = 0;
    int yellowCardTeamA=0;
    int redCardTeamA=0;
    // Tracks the score for Team B
    int scoreTeamB = 0;
    int yellowCardTeamB=0;
    int redCardTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        //Toast with image
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    /**
     * Increase the yellow card for Team A by 1 points.
     */
    public void addOneYellowCardForTeamA(View v) {

        yellowCardTeamA = yellowCardTeamA + 1;
        if ((yellowCardTeamA/2+redCardTeamA)>=11)
        {
            //Toast with text
            Toast.makeText(getApplicationContext(),"No more Player in the court", Toast.LENGTH_SHORT).show();

        }
        else{
            displayYellowForTeamA(yellowCardTeamA);
            //Toast with image
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_yellow,
                    (ViewGroup) findViewById(R.id.custom_toast_containeryellow));

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

        }


    }

    /**
     * Increase the red card for Team A by 1 points.
     */
    public void addOneRedCardForTeamA(View v) {
        redCardTeamA = redCardTeamA + 1;

        if ((redCardTeamA+yellowCardTeamA/2)>=11)
        {
            //Toast with text
            Toast.makeText(getApplicationContext(),"No more Player in the court", Toast.LENGTH_SHORT).show();
        }else{
            displayRedForTeamA(redCardTeamA);
            //Toast with image
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_red,
                    (ViewGroup) findViewById(R.id.custom_toast_containerred));

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }

    }
    /**
     * Increase the score for Team B by 1 points.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        //Toast with image
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast2,
                (ViewGroup) findViewById(R.id.custom_toast_container2));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    /**
     * Increase the yellow card for Team B by 1 .
     */
    public void addOneYellowCardForTeamB(View v) {
        yellowCardTeamB = yellowCardTeamB + 1;
        if ((yellowCardTeamB/2+redCardTeamB)>=11)
        {
            //Toast with text
            Toast.makeText(getApplicationContext(),"No more Player in the court", Toast.LENGTH_SHORT).show();
        }
        else{
            displayYellowForTeamB(yellowCardTeamB);
            //Toast with image
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_yellow,
                    (ViewGroup) findViewById(R.id.custom_toast_containeryellow));

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    }

    /**
     * Increase the red card for Team B by 1 point.
     */
    public void addOneRedCardForTeamB(View v) {
        redCardTeamB = redCardTeamB + 1;

        if ((redCardTeamB+yellowCardTeamB/2)>=11)
        {
            //Toast with text
            Toast.makeText(getApplicationContext(),"No more Player in the court", Toast.LENGTH_SHORT).show();

        }else{
            displayRedForTeamB(redCardTeamB);

            //Toast with image
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_red,
                    (ViewGroup) findViewById(R.id.custom_toast_containerred));

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

        }
    }



    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        yellowCardTeamA=0;
        yellowCardTeamB=0;
        redCardTeamA=0;
        redCardTeamB=0;
        displayForTeamA(scoreTeamA);
        displayYellowForTeamA(yellowCardTeamA);
        displayRedForTeamA(redCardTeamA);
        displayForTeamB(scoreTeamB);
        displayYellowForTeamB(yellowCardTeamB);
        displayRedForTeamB(redCardTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given yellow cards for Team A.
     */
    public void displayYellowForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_yellow);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given red cards for Team A.
     */
    public void displayRedForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_red);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given yellow cards for Team A.
     */
    public void displayYellowForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_yellow);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given red cards for Team A.
     */
    public void displayRedForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_red);
        scoreView.setText(String.valueOf(score));
    }
}