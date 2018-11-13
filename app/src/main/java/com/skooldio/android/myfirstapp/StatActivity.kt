package com.skooldio.android.myfirstapp

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_stat.*

class StatActivity : AppCompatActivity() {

    private val sharePreference by lazy { PreferenceManager.getDefaultSharedPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        firstRangeTextView.text = sharePreference.getInt(MainActivity.FIRST_RANGE_COUNTER, 0).toString()
        secondRangeTextView.text = sharePreference.getInt(MainActivity.SECOND_RANGE_COUNTER, 0).toString()
        thirdRangeTextView.text = sharePreference.getInt(MainActivity.THIRD_RANGE_COUNTER, 0).toString()
        fourthRangeTextView.text = sharePreference.getInt(MainActivity.FOURTH_RANGE_COUNTER, 0).toString()
        fifthRangeTextView.text = sharePreference.getInt(MainActivity.FIFTH_RANGE_COUNTER, 0).toString()
        otherRangeTextView.text = sharePreference.getInt(MainActivity.OTHER_COUNTER, 0).toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
