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

    val resetButton: Button by lazy { findViewById<Button>(R.id.resetButton) }
    val randomButton: Button by lazy { findViewById<Button>(R.id.randomButton) }
    val numberTextView: TextView by lazy { findViewById<TextView>(R.id.numberTextView) }
    val layout: ConstraintLayout by lazy { findViewById<ConstraintLayout>(R.id.constraintLayout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
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
        val toastMessage: String
        layout.setBackgroundColor(when {
            isPrimeNumber(number) -> {
                toastMessage = "Prime Number"
                ContextCompat.getColor(this, android.R.color.black)
            }
            isEven(number) -> {
                toastMessage = "Even Number"
                ContextCompat.getColor(this, android.R.color.holo_blue_dark)
            }
            isOdd(number) -> {
                toastMessage = "Odd Number"
                ContextCompat.getColor(this, android.R.color.holo_red_dark)
            }
            else -> {
                toastMessage = "Unknown"
                ContextCompat.getColor(this, android.R.color.black)
            }
        })
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }

    private fun isEven(number: Int) = number % 2 == 0


    private fun isOdd(number: Int) = number % 2 != 0


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
