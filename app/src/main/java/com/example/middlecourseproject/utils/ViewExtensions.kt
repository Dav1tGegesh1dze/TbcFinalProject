package com.example.middlecourseproject.utils

import android.view.View
import android.widget.Spinner
import android.widget.AdapterView
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}

fun Spinner.onItemSelected(
    onItemSelected: (position: Int) -> Unit,
    onNothingSelected: (() -> Unit)? = null
) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            onItemSelected(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            onNothingSelected?.invoke()
        }
    }
}

fun String.truncate(maxLength: Int): String =
    if (this.length > maxLength) this.take(maxLength) + "..." else this

