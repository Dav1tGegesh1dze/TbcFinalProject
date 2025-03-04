package com.example.middlecourseproject.presentation.food.dish


import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.middlecourseproject.R

import com.example.middlecourseproject.domain.utils.Resource
import com.example.middlecourseproject.databinding.FragmentDishBinding
import com.example.middlecourseproject.domain.imageLoading.ImageLoader
import com.example.middlecourseproject.domain.models.Dish
import com.example.middlecourseproject.presentation.adapter.DishAdapter
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class DishFragment : BaseFragment<FragmentDishBinding>(FragmentDishBinding::inflate) {

    private val args: DishFragmentArgs by navArgs()

    @Inject
    lateinit var imageLoader: ImageLoader

    private val dishViewModel : DishViewModel by viewModels ()

    override fun start() {
        dishViewModel.fetchDish(args.id)
        observeDish()
        goBack()
    }


    private fun observeDish() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                dishViewModel.dish.collect { resource ->
                    when (resource) {
                        is Resource.Idle ->{
                            binding.progressBar.visibility = View.GONE
                        }
                        is Resource.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            setUpDish(resource.data)
                            attachItemsContainer(resource.data.ingredients)
                        }

                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.root.showSnackbar(resource.message)
                        }
                    }
                }
            }
        }
    }
    private fun handleSourceButtonClick(url: String) {
        binding.source.isEnabled = false
        binding.source.text = getString(R.string.loading)
        viewLifecycleOwner.lifecycleScope.launch {
            delay(300)
            try {
                openSourceUrl(url)
            } finally {
                binding.source.isEnabled = true
                binding.source.text = getString(R.string.view_source)
            }
        }
    }

    private fun openSourceUrl(url: String) {
        try {
            val validUrl = if (!url.startsWith("http://") && !url.startsWith("https://"))
                "http://$url" else url

            val uri = Uri.parse(validUrl)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                binding.root.showSnackbar(getString(R.string.no_app_for_url))
            }
        } catch (e: Exception) {
            binding.root.showSnackbar(getString(R.string.invalid_url))
        }
    }
    private fun setUpDish(dish: Dish) {
        imageLoader.loadImage(binding.dishImage, dish.imageUrl)
        binding.dishName.text = dish.title
        binding.dishRating.text = "${dish.socialRank} ★"
        binding.source.setOnClickListener {
            handleSourceButtonClick(dish.sourceUrl)
        }
    }

    private fun goBack( ) {
        binding.goBack.setOnClickListener{
            findNavController().popBackStack()
        }
    }


    private fun attachItemsContainer (ingredients :List<String> ) {
        binding.ingredients.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.ingredients.adapter = DishAdapter(ingredients)
    }


}