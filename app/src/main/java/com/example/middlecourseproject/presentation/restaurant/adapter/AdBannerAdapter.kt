package com.example.middlecourseproject.presentation.restaurant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ItemAdBannerBinding
import com.example.middlecourseproject.domain.restaurant.model.AdBanner

class AdBannerAdapter(
    private val onAdClicked: (AdBanner) -> Unit
) : ListAdapter<AdBanner, AdBannerAdapter.AdBannerViewHolder>(AdBannerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdBannerViewHolder {
        val binding = ItemAdBannerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AdBannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdBannerViewHolder, position: Int) {
        val adBanner = getItem(position)
        holder.bind(adBanner)
    }

    inner class AdBannerViewHolder(
        private val binding: ItemAdBannerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val adBanner = getItem(position)
                    onAdClicked(adBanner)  // Pass the entire AdBanner object
                }
            }
        }

        fun bind(adBanner: AdBanner) {
            binding.tvAdTitle.text = adBanner.title

            // Remove the description - just show title
            binding.tvAdDescription.visibility = View.GONE

            // Set background color if available
            adBanner.backgroundColor?.let { colorString ->
                try {
                    binding.adBannerBackground.setBackgroundColor(colorString.toColorInt())
                } catch (e: Exception) {
                    // Use default background if color parsing fails
                    binding.adBannerBackground.setBackgroundResource(R.color.white)
                }
            }

            // Handle different media types
            when (adBanner.mediaType) {
                "image", "gif" -> {
                    binding.ivAdImage.visibility = View.VISIBLE
                    binding.videoAdContainer.visibility = View.GONE

                    Glide.with(binding.root.context)
                        .load(adBanner.mediaUrl)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(binding.ivAdImage)
                }
                "video" -> {
                    binding.ivAdImage.visibility = View.GONE
                    binding.videoAdContainer.visibility = View.VISIBLE

                    // For video thumbnails, we'll just show the thumbnail image for now
                    Glide.with(binding.root.context)
                        .load(adBanner.thumbnailUrl ?: adBanner.mediaUrl)
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(binding.videoThumbnail)

                    binding.playButton.visibility = View.VISIBLE
                }
                else -> {
                    // Fallback to image
                    binding.ivAdImage.visibility = View.VISIBLE
                    binding.videoAdContainer.visibility = View.GONE

                    Glide.with(binding.root.context)
                        .load(adBanner.mediaUrl)
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(binding.ivAdImage)
                }
            }
        }
    }

    private class AdBannerDiffCallback : DiffUtil.ItemCallback<AdBanner>() {
        override fun areItemsTheSame(oldItem: AdBanner, newItem: AdBanner): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AdBanner, newItem: AdBanner): Boolean {
            return oldItem == newItem
        }
    }
}