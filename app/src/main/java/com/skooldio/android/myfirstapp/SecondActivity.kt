package com.skooldio.android.myfirstapp

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class SecondActivity : AppCompatActivity() {

    lateinit var resetButton: Button
    lateinit var randomButton: Button
    lateinit var numberTextView: TextView
    lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        layout = findViewById(R.id.constraintLayout)
        resetButton = findViewById(R.id.resetButton)
        randomButton = findViewById(R.id.randomButton)
        numberTextView = findViewById(R.id.numberTextView)

        initUi()
    }

    private fun initUi() {
        numberTextView.text = "0"
        updateBackgroundColor(0)

        resetButton.setOnClickListener {
            numberTextView.text = "0"
            updateBackgroundColor(0)
        }

        randomButton.setOnClickListener {
            val randomInt = randomInt(50)
            numberTextView.text = randomInt.toString()
            updateBackgroundColor(randomInt)
        }
    }

    private fun randomInt(maximum: Int): Int {
        val random = Random()
        return random.nextInt(maximum) + 1
    }

    private fun updateBackgroundColor(number: Int) {
        val colorRes: Int
        val toastMessage: String
        when {
            isPrimeNumber(number) -> {
                colorRes = ContextCompat.getColor(this, android.R.color.black)
                toastMessage = "Prime Number"
            }
            isEven(number) -> {
                colorRes = ContextCompat.getColor(this, android.R.color.holo_blue_dark)
                toastMessage = "Even Number"
            }
            isOdd(number) -> {
                colorRes = ContextCompat.getColor(this, android.R.color.holo_red_dark)
                toastMessage = "Odd Number"
            }
            else -> {
                toastMessage = "Unknown"
                colorRes = ContextCompat.getColor(this, android.R.color.black)
            }
        }
        layout.setBackgroundColor(colorRes)
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }

    private fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    private fun isOdd(number: Int): Boolean {
        return number % 2 != 0
    }

    private fun isPrimeNumber(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        for (i in 2..number / 2) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}
