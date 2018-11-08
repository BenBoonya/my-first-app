package com.skooldio.android.myfirstapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    Button resetButton;
    Button randomButton;
    TextView numberTextView;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        constraintLayout = findViewById(R.id.constraintLayout);
        resetButton = findViewById(R.id.resetButton);
        randomButton = findViewById(R.id.randomButton);
        numberTextView = findViewById(R.id.numberTextView);

        initUi();
    }

    private void initUi() {
        numberTextView.setText("0");
        updateBackgroundColor(0);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberTextView.setText("0");
                updateBackgroundColor(0);
            }
        });

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer randomInt = randomInt(50);
                numberTextView.setText(randomInt.toString());
                updateBackgroundColor(randomInt);
            }
        });
    }

    private Integer randomInt(Integer maximum) {
        Random random = new Random();
        return random.nextInt(maximum) + 1;
    }

    private void updateBackgroundColor(Integer number) {
        Resources resource = getResources();
        Integer colorRes;
        String toastMessage;
        if (isPrimeNumber(number)) {
            colorRes = resource.getColor(android.R.color.black);
            toastMessage = "Prime Number";
        } else if (isEven(number)) {
            colorRes = resource.getColor(android.R.color.holo_blue_dark);
            toastMessage = "Even Number";
        } else if (isOdd(number)) {
            colorRes = resource.getColor(android.R.color.holo_red_dark);
            toastMessage = "Odd Number";
        } else {
            toastMessage = "Unknown";
            colorRes = resource.getColor(android.R.color.black);
        }
        constraintLayout.setBackgroundColor(colorRes);
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    private Boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    private Boolean isOdd(Integer number) {
        return number % 2 != 0;
    }

    private Boolean isPrimeNumber(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
