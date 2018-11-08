package com.skooldio.android.myfirstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.skooldio.android.myfirstapp.extension.getColorCompat
import com.skooldio.android.myfirstapp.extension.toast
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {

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
        val colorRes: Int
        val toastMessage: String
        when {
            isPrimeNumber(number) -> {
                colorRes = getColorCompat(android.R.color.black)
                toastMessage = "Prime Number"
            }
            isEven(number) -> {
                colorRes = getColorCompat(android.R.color.holo_blue_dark)
                toastMessage = "Even Number"
            }
            isOdd(number) -> {
                colorRes = getColorCompat(android.R.color.holo_red_dark)
                toastMessage = "Odd Number"
            }
            else -> {
                toastMessage = "Unknown"
                colorRes = getColorCompat(android.R.color.black)
            }
        }
        constraintLayout.setBackgroundColor(colorRes)
        toast(toastMessage)
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
