package com.example.middlecourseproject.domain.checkout.manager

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Singleton manager class to track active orders across the app
 */
@Singleton
class OrderManager @Inject constructor(
    context: Context
) {
    companion object {
        private const val PREFS_NAME = "order_prefs"
        private const val KEY_ACTIVE_ORDER = "active_order"
        private const val KEY_DELIVERY_TIME = "delivery_time"
        private const val KEY_ORDER_PLACED_TIME = "order_placed_time"
        private const val KEY_DELIVERY_ADDRESS = "delivery_address"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    /**
     * Create a new order and save its details
     */
    fun createOrder(deliveryTimeMinutes: Int, deliveryAddress: String) {
        val currentTime = System.currentTimeMillis()
        val deliveryTime = currentTime + (deliveryTimeMinutes * 60 * 1000)

        prefs.edit()
            .putBoolean(KEY_ACTIVE_ORDER, true)
            .putLong(KEY_DELIVERY_TIME, deliveryTime)
            .putLong(KEY_ORDER_PLACED_TIME, currentTime)
            .putString(KEY_DELIVERY_ADDRESS, deliveryAddress)
            .apply()
    }

    /**
     * Check if there's an active order
     */
    fun hasActiveOrder(): Boolean {
        return prefs.getBoolean(KEY_ACTIVE_ORDER, false)
    }

    /**
     * Get the remaining time in milliseconds until delivery
     * Returns null if no active order
     */
    fun getRemainingTimeMillis(): Long? {
        if (!hasActiveOrder()) return null

        val deliveryTime = prefs.getLong(KEY_DELIVERY_TIME, 0)
        val remainingTime = deliveryTime - System.currentTimeMillis()

        // If time is up or negative, return 0
        return if (remainingTime <= 0) 0 else remainingTime
    }

    /**
     * Get the estimated delivery time in millis since epoch
     */
    fun getDeliveryTimeMillis(): Long {
        return prefs.getLong(KEY_DELIVERY_TIME, 0)
    }

    /**
     * Get the time when the order was placed
     */
    fun getOrderPlacedTimeMillis(): Long {
        return prefs.getLong(KEY_ORDER_PLACED_TIME, 0)
    }

    /**
     * Get the delivery address
     */
    fun getDeliveryAddress(): String {
        return prefs.getString(KEY_DELIVERY_ADDRESS, "") ?: ""
    }

    /**
     * Complete the current order
     */
    fun completeOrder() {
        prefs.edit()
            .putBoolean(KEY_ACTIVE_ORDER, false)
            .apply()
    }
}