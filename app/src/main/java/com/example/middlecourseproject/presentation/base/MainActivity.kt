package com.example.middlecourseproject.presentation.base

import android.content.Context
import android.content.res.Configuration
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.ActivityMainBinding
import com.example.middlecourseproject.di.LocaleHelperEntryPoint
import com.example.middlecourseproject.domain.theme.ThemeManager
import com.example.middlecourseproject.domain.useCases.CheckAuthTokenUseCase
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var checkAuthTokenUseCase: CheckAuthTokenUseCase

    @Inject
    lateinit var themeManager: ThemeManager

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
        observeThemeChanges()
        Log.d("MainActivity", "onCreate: created")
    }

    private fun observeThemeChanges() {
        lifecycleScope.launch {
            themeManager.isDarkMode.collect { isDarkMode ->
                Log.d("MainActivity", "Theme changed to dark mode: $isDarkMode")
                updateBottomNavigationTheme()
            }
        }
    }

    private fun updateBottomNavigationTheme() {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Force recreation of the bottom navigation colors
        bottomNav.itemIconTintList = null
        bottomNav.itemIconTintList = AppCompatResources.getColorStateList(
            this,
            R.color.bottom_nav_item_color
        )

        bottomNav.itemTextColor = null
        bottomNav.itemTextColor = AppCompatResources.getColorStateList(
            this,
            R.color.bottom_nav_item_color
        )

        // Update background
        bottomNav.setBackgroundResource(0) // Clear existing background
        val typedValue = TypedValue()
        theme.resolveAttribute(com.google.android.material.R.attr.colorSurface, typedValue, true)
        bottomNav.setBackgroundColor(typedValue.data)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // This will be called when the UI mode changes (dark/light)
        Log.d("MainActivity", "Configuration changed: ${newConfig.uiMode}")

        // Update bottom navigation when configuration changes
        if ((newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES ||
            (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO) {
            updateBottomNavigationTheme()
        }
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Important: Create a new NavGraph instance but don't set it immediately
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        // Bottom Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setupWithNavController(navController)

        // Check authentication status before setting the start destination
        lifecycleScope.launch {
            val isLoggedIn = checkAuthTokenUseCase()

            // Set the appropriate start destination based on login status
            if (isLoggedIn) {
                navGraph.setStartDestination(R.id.restaurantFragment)
                Log.d("MainActivity", "User is logged in, navigating to Restaurant Fragment")
            } else {
                navGraph.setStartDestination(R.id.loginFragment)
                Log.d("MainActivity", "User is not logged in, navigating to Login Fragment")
            }

            // Apply the navigation graph AFTER setting the start destination
            navController.graph = navGraph
            isNavigationReady = true
        }

        // Set up destination changed listener for showing/hiding bottom nav
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment, R.id.registerFragment,
                R.id.otpValidation, R.id.detailsFragment, R.id.adDetailFragment,
                R.id.checkoutFragment, R.id.orderConfirmationFragment, R.id.paymentFragment-> {
                    bottomNavigationView.visibility = View.GONE
                }
                else -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }
    }
}