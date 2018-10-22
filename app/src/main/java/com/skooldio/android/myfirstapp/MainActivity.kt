package com.skooldio.android.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        //the component name should be exactly the same as id in XML
        constraintLayout.setBackgroundColor(when (number) {
            in 1..10 -> ContextCompat.getColor(this, android.R.color.holo_red_dark)
            in 11..20 -> ContextCompat.getColor(this, android.R.color.holo_green_dark)
            in 21..30 -> ContextCompat.getColor(this, android.R.color.holo_blue_dark)
            in 31..40 -> ContextCompat.getColor(this, android.R.color.holo_orange_dark)
            in 41..50 -> ContextCompat.getColor(this, android.R.color.holo_purple)
            else -> ContextCompat.getColor(this, android.R.color.black)
        })
    }

    private fun navigateToStatScreen() {
        startActivity(Intent(this, StatActivity::class.java))
    }
}
