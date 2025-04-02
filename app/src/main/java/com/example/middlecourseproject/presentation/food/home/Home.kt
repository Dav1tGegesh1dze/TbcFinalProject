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
import com.example.middlecourseproject.presentation.imageLoading.ImageLoader
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Home : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun start() {

    }

}
