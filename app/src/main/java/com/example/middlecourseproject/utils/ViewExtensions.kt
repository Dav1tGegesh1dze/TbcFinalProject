package com.example.middlecourseproject.utils

import android.view.View
import android.widget.Spinner
import android.widget.AdapterView
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}

// Extension function to set an item selected listener for Spinner.
fun Spinner.onItemSelected(onItemSelected: (position: Int) -> Unit) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            parent: AdapterView<*>?, view: View?, position: Int, id: Long
        ) {
            onItemSelected(position)
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
}