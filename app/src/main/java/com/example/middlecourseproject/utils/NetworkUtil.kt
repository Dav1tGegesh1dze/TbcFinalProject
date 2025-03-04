package com.example.middlecourseproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkUtil @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val _isNetworkAvailable = MutableStateFlow(checkNetwork())
    val isNetworkAvailableFlow = _isNetworkAvailable.asStateFlow()
    private var isCallbackRegistered = false

    private fun checkNetwork(): Boolean {
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            _isNetworkAvailable.value = true
        }
        override fun onLost(network: Network) {
            _isNetworkAvailable.value = checkNetwork()
        }
    }

    fun startNetworkCallback() {
        if (!isCallbackRegistered) {
            val networkRequest = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .build()
            connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
            isCallbackRegistered = true
        }
    }

    fun stopNetworkCallback() {
        if (isCallbackRegistered) {
            connectivityManager.unregisterNetworkCallback(networkCallback)
            isCallbackRegistered = false
        }
    }
}
