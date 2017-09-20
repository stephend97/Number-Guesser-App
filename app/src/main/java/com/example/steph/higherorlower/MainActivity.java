package com.example.steph.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int ranNum;
    int counter = 1;

    //validates user input
    public void runGame(View view){
        EditText guess = (EditText) findViewById(R.id.guessBox);
        int parsedGuess;

        try{
            parsedGuess = Integer.parseInt(guess.getText().toString());
            showOutput(parsedGuess);

        }
        catch(RuntimeException e){
            makeToast("Not valid input. Try again.");
        }
    }//end of runGame

    //takes in user guess, shows how close they are
    public void showOutput(int localParsedGuess){
        if(localParsedGuess > ranNum){
            makeToast("Guess lower");
            counter++;
        }
        else if(localParsedGuess < ranNum){
            makeToast("Guess higher");
            counter++;
        }
        else {
            makeToast("Correct! It took you " + counter +" guesses. Try again!");
            counter = 1;
            Random rand = new Random();
            ranNum = rand.nextInt(100) + 1;
        }

    }//end of showInput

    public void makeToast(String str){
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }//end of makeToast

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        ranNum = rand.nextInt(100) + 1;
    }//end of onCreate
}//end of MainActivity