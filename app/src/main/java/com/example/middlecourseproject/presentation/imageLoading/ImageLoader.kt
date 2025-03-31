package com.example.middlecourseproject.presentation.imageLoading

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.example.middlecourseproject.R

interface ImageLoader {
    fun loadImage(
        imageView: ImageView,
        url: String,
        @DrawableRes placeholderRes: Int = R.drawable.placeholder_image,
        @DrawableRes errorRes: Int = R.drawable.error_image
    )
}