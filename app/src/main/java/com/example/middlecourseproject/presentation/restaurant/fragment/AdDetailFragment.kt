package com.example.middlecourseproject.presentation.restaurant.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentAdDetailBinding
import com.example.middlecourseproject.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdDetailFragment : BaseFragment<FragmentAdDetailBinding>(
    FragmentAdDetailBinding::inflate
) {
    private val args: AdDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun start() {
        setupUI()
        setupBackButton()
    }

    private fun setupUI() {
        val adBanner = args.adBanner


        binding.tvAdTitle.text = adBanner.title
        binding.tvAdDescription.text = adBanner.description

        binding.btnAction.visibility = View.GONE

        binding.ivAdImage.visibility = View.VISIBLE
        binding.videoContainer.visibility = View.GONE

        Glide.with(requireContext())
            .load(adBanner.thumbnailUrl ?: adBanner.mediaUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivAdImage)
    }

    private fun setupBackButton() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}