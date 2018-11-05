package com.skooldio.android.myfirstapp.extension

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by Boonya Kitpitak on 11/5/18.
 */
fun Context.getColorCompat(res: Int) = ContextCompat.getColor(this, res)