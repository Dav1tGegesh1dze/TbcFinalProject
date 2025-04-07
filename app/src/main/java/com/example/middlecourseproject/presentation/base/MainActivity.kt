package com.example.middlecourseproject.presentation.base

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ActivityMainBinding
import com.example.middlecourseproject.di.LocaleHelperEntryPoint
import com.example.middlecourseproject.domain.useCases.CheckAuthTokenUseCase
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var checkAuthTokenUseCase: CheckAuthTokenUseCase

    @Volatile
    private var isNavigationReady: Boolean = false

    override fun attachBaseContext(newBase: Context) {
        val entryPoint = EntryPointAccessors.fromApplication(
            newBase.applicationContext, LocaleHelperEntryPoint::class.java
        )
        val langCode = entryPoint.preferencesHelper().getLanguage()
        val configContext = entryPoint.localeHelper().applyLocale(newBase, langCode)
        super.attachBaseContext(configContext)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            currentFocus?.let { focusedView ->
                val outRect = Rect()
                focusedView.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    focusedView.clearFocus()
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(focusedView.windowToken, 0)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { !isNavigationReady }

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
        Log.d("MainActivity", "onCreate: created")
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        // Bottom Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment, R.id.registerFragment,
                R.id.otpValidation, R.id.detailsFragment -> {
                    bottomNavigationView.visibility = View.GONE
                }
                else -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }

        // Start
        navGraph.setStartDestination(R.id.restaurantFragment)
        navController.graph = navGraph
        isNavigationReady = true

        Log.d("MainActivity", "Navigating to Restaurant Fragment")

        //Commented that
        /*
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
            isNavigationReady = true
        }
        */
    }
}