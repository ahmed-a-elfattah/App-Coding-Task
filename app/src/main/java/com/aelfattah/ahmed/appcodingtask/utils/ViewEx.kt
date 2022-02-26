package com.aelfattah.ahmed.appcodingtask.utils

import android.app.Activity
import android.view.View
import android.widget.Toast
import com.aelfattah.ahmed.appcodingtask.R
import com.google.android.material.snackbar.Snackbar

fun View.isVisible(show: Boolean) {
    when (show) {
        true -> this.visibility = View.VISIBLE
        false -> this.visibility = View.GONE
    }
}

fun Activity.showSnack(message: String, action: (() -> Unit)?) {
    val snack =
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE)
    snack.setAction(getString(R.string.ok)) {
        if (action != null) {
            action()
        }
        snack.dismiss()
    }.show()
}

fun Activity.showToast(message: String) {
    Toast.makeText(this.applicationContext, message, Toast.LENGTH_LONG).show()
}