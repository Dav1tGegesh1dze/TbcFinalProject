package com.example.middlecourseproject.presentation.imageLoading

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.middlecourseproject.domain.imageLoading.ImageLoader
import javax.inject.Inject

class GlideImageLoader @Inject constructor() : ImageLoader {
    override fun loadImage(
        imageView: ImageView,
        url: String,
        @DrawableRes placeholderRes: Int,
        @DrawableRes errorRes: Int
    ) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(placeholderRes)
            .error(errorRes)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }
}