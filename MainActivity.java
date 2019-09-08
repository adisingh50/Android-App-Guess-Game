package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView triesleft = findViewById(R.id.tries_left);
        triesleft.setText("5");
    }


    Random random = new Random();
    int actualnum = random.nextInt(20)+1;
    int attemptsleft = 5;
    boolean gamestatus = true;


    public void onbuttonclick(View view) {
        EditText numguess = findViewById(R.id.numGuess);
        TextView triesleft = findViewById(R.id.tries_left);
        TextView feedback = findViewById(R.id.feedback);

        if(gamestatus) {
            if (attemptsleft > 0) {
                int guessnum = Integer.parseInt(numguess.getText().toString());

                if (guessnum > actualnum) {
                    feedback.setText("Too High!");
                } else if (guessnum < actualnum) {
                    feedback.setText("Too Low");
                } else {
                    feedback.setText("YOU WIN!!!");
                    gamestatus = false;
                }
                attemptsleft--;
                triesleft.setText(attemptsleft);
            } else {
                feedback.setText("Game Over!!");
                gamestatus = false;
            }
        }
    }
}
