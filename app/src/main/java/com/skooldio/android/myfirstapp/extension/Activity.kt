package com.skooldio.android.myfirstapp.extension

import android.app.Activity
import android.widget.Toast

/**
 * Created by Boonya Kitpitak on 10/21/18.
 */
fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}