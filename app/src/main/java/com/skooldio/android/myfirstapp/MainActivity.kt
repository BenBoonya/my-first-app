package com.skooldio.android.myfirstapp

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.skooldio.android.myfirstapp.extension.getColorCompat
import com.skooldio.android.myfirstapp.extension.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    internal val resetButton: Button by lazy { findViewById<Button>(R.id.resetButton) }
    internal val countButton: Button by lazy { findViewById<Button>(R.id.countButton) }
    internal val randomButton: Button by lazy { findViewById<Button>(R.id.randomButton) }
    internal val numberTextView: TextView by lazy { findViewById<TextView>(R.id.numberTextView) }
    internal val layout: ConstraintLayout by lazy { findViewById<ConstraintLayout>(R.id.constraintLayout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    private fun updateBackgroundColor(number: Int) =
            layout.setBackgroundColor(when (number) {
                in 1..10 -> {
                    toast("1..10 (Long)", Toast.LENGTH_LONG)
                    getColorCompat(android.R.color.holo_red_dark)
                }
                in 11..20 -> {
                    toast("11..20 (Short)")
                    getColorCompat(android.R.color.holo_green_dark)
                }
                in 21..30 -> {
                    toast("21..30 (Long)", Toast.LENGTH_LONG)
                    getColorCompat(android.R.color.holo_blue_dark)
                }
                in 31..40 -> {
                    toast("31..40 (Short)")
                    getColorCompat(android.R.color.holo_orange_dark)
                }
                in 41..50 -> {
                    toast("41..50 (Long)", Toast.LENGTH_LONG)
                    getColorCompat(android.R.color.holo_purple)
                }
                else -> {
                    toast("other (short)")
                    getColorCompat(android.R.color.black)
                }
            })
}
