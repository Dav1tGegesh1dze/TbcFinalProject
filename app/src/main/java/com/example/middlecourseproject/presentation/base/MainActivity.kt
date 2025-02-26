package com.example.middlecourseproject.presentation.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ActivityMainBinding
import com.example.middlecourseproject.di.LocaleHelperEntryPoint
import com.example.middlecourseproject.domain.useCases.CheckAuthTokenUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Inject the CheckAuthTokenUseCase instead of DataStoreManager.
    @Inject lateinit var checkAuthTokenUseCase: CheckAuthTokenUseCase

    override fun attachBaseContext(newBase: Context) {
        // Retrieve the entry point for locale-related helpers.
        val entryPoint = EntryPointAccessors.fromApplication(
            newBase.applicationContext, LocaleHelperEntryPoint::class.java
        )
        val savedLang = entryPoint.preferencesHelper().getLanguage()
        val configContext = entryPoint.localeHelper().applyLocale(newBase, savedLang)
        super.attachBaseContext(configContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nag_graph)

        lifecycleScope.launch {
            val isValid = checkAuthTokenUseCase()
            if (isValid) {
                navGraph.setStartDestination(R.id.home2)
                Log.d("MainActivity", "Token is valid. Navigating to Home")
            } else {
                navGraph.setStartDestination(R.id.loginFragment)
                Log.d("MainActivity", "No valid token found. Navigating to Login")
            }
            navController.graph = navGraph
        }
    }
}