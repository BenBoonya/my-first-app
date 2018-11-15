package com.skooldio.android.myfirstapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.skooldio.android.myfirstapp.extension.getColorCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val FIRST_RANGE_COUNTER = "first_range_counter"
        const val SECOND_RANGE_COUNTER = "second_range_counter"
        const val THIRD_RANGE_COUNTER = "third_range_counter"
        const val FOURTH_RANGE_COUNTER = "fourth_range_counter"
        const val FIFTH_RANGE_COUNTER = "fifth_range_counter"
        const val OTHER_COUNTER = "other_counter"
    }

    private lateinit var sharePreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharePreference = PreferenceManager.getDefaultSharedPreferences(this)
        initUi()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_stat, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.stat_screen) {
            navigateToStatScreen()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUi() {
        numberTextView.text = "0"

        countButton.setOnClickListener { countMe(numberTextView) }

        resetButton.setOnClickListener {
            numberTextView.text = "0"
            updateBackgroundColor(0)
        }

        randomButton.setOnClickListener {
            randomInt(50).let {
                numberTextView.text = it.toString()
                updateBackgroundColor(it)
            }
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
        count.let {
            updateBackgroundColor(it)
            textView.text = it.toString()
        }
    }

    private fun updateBackgroundColor(number: Int) =
            constraintLayout.setBackgroundColor(when (number) {
                in 1..10 -> {
                    increaseCounter(FIRST_RANGE_COUNTER)
                    getColorCompat(android.R.color.holo_red_dark)
                }
                in 11..20 -> {
                    increaseCounter(SECOND_RANGE_COUNTER)
                    getColorCompat(android.R.color.holo_green_dark)
                }
                in 21..30 -> {
                    increaseCounter(THIRD_RANGE_COUNTER)
                    getColorCompat(android.R.color.holo_blue_dark)
                }
                in 31..40 -> {
                    increaseCounter(FOURTH_RANGE_COUNTER)
                    getColorCompat(android.R.color.holo_orange_dark)
                }
                in 41..50 -> {
                    increaseCounter(FIFTH_RANGE_COUNTER)
                    getColorCompat(android.R.color.holo_purple)
                }
                else -> {
                    increaseCounter(OTHER_COUNTER)
                    getColorCompat(android.R.color.black)
                }
            })

    private fun navigateToStatScreen() {
        startActivity(Intent(this, StatActivity::class.java))
    }

    private fun increaseCounter(key: String) {
        with(sharePreference) {
            var counter = getInt(key, 0)
            counter++
            edit().putInt(key, counter).apply()
        }
    }
}
