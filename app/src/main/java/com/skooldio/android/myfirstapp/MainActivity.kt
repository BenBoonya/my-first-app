package com.skooldio.android.myfirstapp

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var resetButton: Button
    private lateinit var countButton: Button
    private lateinit var randomButton: Button
    private lateinit var numberTextView: TextView
    private lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.constraintLayout)
        resetButton = findViewById(R.id.resetButton)
        countButton = findViewById(R.id.countButton)
        randomButton = findViewById(R.id.randomButton)
        numberTextView = findViewById(R.id.numberTextView)

        initUi()
    }

    private fun initUi() {
        numberTextView.text = "0"

        countButton.setOnClickListener { countMe(numberTextView) }

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

    private fun countMe(textView: TextView) {
        val countString = textView.text.toString()
        var count: Int = Integer.parseInt(countString)
        count++
        updateBackgroundColor(count)
        textView.text = count.toString()
    }

    private fun updateBackgroundColor(number: Int) {
        layout.setBackgroundColor(when (number) {
            in 1..10 -> {
                Toast.makeText(this, "1 - 10", Toast.LENGTH_SHORT).show()
                ContextCompat.getColor(this, android.R.color.holo_red_dark)
            }
            in 11..20 -> {
                Toast.makeText(this, "11 - 20", Toast.LENGTH_SHORT).show()
                ContextCompat.getColor(this, android.R.color.holo_green_dark)
            }
            in 21..30 -> {
                Toast.makeText(this, "21 - 30", Toast.LENGTH_SHORT).show()
                ContextCompat.getColor(this, android.R.color.holo_blue_dark)
            }
            in 31..40 -> {
                Toast.makeText(this, "31 - 40", Toast.LENGTH_SHORT).show()
                ContextCompat.getColor(this, android.R.color.holo_orange_dark)
            }
            in 41..50 -> {
                Toast.makeText(this, "41 - 50", Toast.LENGTH_SHORT).show()
                ContextCompat.getColor(this, android.R.color.holo_purple)
            }
            else -> {
                Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show()
                ContextCompat.getColor(this, android.R.color.black)
            }
        })
    }
}
