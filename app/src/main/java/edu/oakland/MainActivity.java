package edu.oakland;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String [] arr = {"🌭", "🍎", "🍿", "🥯", "🥙", "🍜", "🍰", "🍵", "🍷", "🍇", "🍬", "🍒", "🥑", "🧄", "🍭", "🥝", "🍄", "🍡"};
    String [] word = {"Great", "Good Job", "Well Done", "Excellent", "Perfect", "Amazing", "WOW", "Keep it up", "Keep Going", "Awesome"};
    CountDownTimer myTimer;
    TextView fruit, scoreTV;
    float x, y;
    int i=0, w=0, score=0;
    Random rn = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTV = findViewById(R.id.score);
        fruit = findViewById(R.id.myTv);
        fruit.setTextColor(Color.parseColor("#FFFFFF"));
        fruit.setText(arr[0]);

        fruit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fruit.setText("💥");
                score += 10;
                scoreTV.setText(String.valueOf(score));
                Toast.makeText(MainActivity.this, word[w], Toast.LENGTH_SHORT).show();
                if(w < word.length - 1)
                {
                    w++;
                }
                else{
                    w = 0;
                }

            }
        });

        myTimer = new CountDownTimer(900, 100) {
            @Override
            public void onTick(long ms) {

            }

            @Override
            public void onFinish()
            {
                if (i < arr.length-1)
                {
                    i++;
                }
                else{
                    i = 0;
                }
                fruit.setText(arr[i]);
                x = rn.nextInt(700) + 100;
                fruit.setX(x);
                y = rn.nextInt(1500);
                fruit.setY(y);
                myTimer.start();
            }
        }.start();
    }
}