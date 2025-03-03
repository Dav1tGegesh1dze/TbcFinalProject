// Home.kt (Fragment)
package com.example.middlecourseproject.presentation.food.home

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.middlecourseproject.R
import com.example.middlecourseproject.utils.NetworkUtil
import com.example.middlecourseproject.presentation.base.BaseFragment
import com.example.middlecourseproject.databinding.FragmentHomeBinding
import com.example.middlecourseproject.domain.imageLoading.ImageLoader
import com.example.middlecourseproject.presentation.adapter.FoodAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Home : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    @Inject
    lateinit var imageLoader: ImageLoader

    private val foodAdapter by lazy {
        FoodAdapter(imageLoader) { id -> navigateToDish(id) }
    }
    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var networkUtil: NetworkUtil
    private var currentSnackbar: Snackbar? = null
    override fun start() {
        attachRecycler()
        setupSearch()
        observePagingData()
        loadStateListener()
        observeNetworkChanges()
        goToProfile()
    }

    override fun onStart() {
        super.onStart()
        networkUtil.startNetworkCallback()
    }

    override fun onStop() {
        networkUtil.stopNetworkCallback()
        super.onStop()
    }
    private fun navigateToDish (id : String) {
        findNavController().navigate(HomeDirections.actionHome2ToDishFragment(id))
    }
    private fun goToProfile ( ) {
        binding.toProfile.setOnClickListener {
            findNavController().navigate(HomeDirections.actionHome2ToProfileFragment())
        }
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        networkUtil.startNetworkCallback() // Start monitoring once per fragment instance
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        networkUtil.stopNetworkCallback() // Stop monitoring when fragment is destroyed
//    }

    private fun attachRecycler() {
        binding.foodRecycler.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = foodAdapter
        }
    }

    private fun observeNetworkChanges() {
        viewLifecycleOwner.lifecycleScope.launch {
            networkUtil.isNetworkAvailableFlow.collect { isAvailable ->
                if (viewLifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
                    currentSnackbar?.dismiss()
                    val message = if (isAvailable) {
                       getString(R.string.online_mode)
                    } else {
                        getString(R.string.offline_mode)
                    }
                    currentSnackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
                    currentSnackbar?.show()

                }
            }
        }
    }

    private fun setupSearch() {
        binding.foodSearchButton.setOnClickListener {
            val query = binding.foodSearch.text.toString()
            if (query.isBlank()) {
                Toast.makeText(requireContext(), getString(R.string.fill_all_fields), Toast.LENGTH_LONG).show()
            } else {
                viewLifecycleOwner.lifecycleScope.launch {
                    delay(300) // Simple debounce
                    homeViewModel.searchFood(query)
                }
            }
        }
    }

    private fun observePagingData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.pagingData.collectLatest { pagingData ->
                    foodAdapter.submitData(pagingData)
                }
            }
        }
    }

    private fun loadStateListener() {
        foodAdapter.addLoadStateListener { loadState ->
            val sourceRefresh = loadState.source.refresh
            val mediatorRefresh = loadState.mediator?.refresh

            // Handle UI based on the combined state
            when {
                // Loading state: show progress bar, hide everything else
                sourceRefresh is LoadState.Loading || mediatorRefresh is LoadState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.errorImage.visibility = View.GONE
                    binding.foodRecycler.visibility = View.GONE
                }
                // Source finished loading: decide based on data availability
                sourceRefresh is LoadState.NotLoading -> {
                    binding.progressBar.visibility = View.GONE // Hide loader immediately
                    if (foodAdapter.itemCount > 0) {
                        // Data available, show recycler view
                        binding.errorImage.visibility = View.GONE
                        binding.foodRecycler.visibility = View.VISIBLE
                    } else {
                        // No data, show error image
                        binding.errorImage.visibility = View.VISIBLE
                        binding.foodRecycler.visibility = View.GONE
                    }
                }
                // Source error: show error image immediately
                sourceRefresh is LoadState.Error -> {
                    binding.progressBar.visibility = View.GONE // Hide loader immediately
                    binding.errorImage.visibility = View.VISIBLE
                    binding.foodRecycler.visibility = View.GONE
                }
            }
        }
    }
}
