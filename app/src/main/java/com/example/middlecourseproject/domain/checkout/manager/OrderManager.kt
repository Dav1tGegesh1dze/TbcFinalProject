package com.example.middlecourseproject.domain.checkout.manager

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import com.example.middlecourseproject.domain.checkout.notification.NotificationService
import com.example.middlecourseproject.domain.checkout.notification.OrderTrackingService

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Singleton manager class to track active orders across the app
 */
@Singleton
class OrderManager @Inject constructor(
    private val context: Context,
    private val notificationService: NotificationService
) {
    companion object {
        private const val PREFS_NAME = "order_prefs"
        private const val KEY_ACTIVE_ORDER = "active_order"
        private const val KEY_DELIVERY_TIME = "delivery_time"
        private const val KEY_ORDER_PLACED_TIME = "order_placed_time"
        private const val KEY_DELIVERY_ADDRESS = "delivery_address"
        private const val KEY_ORDER_STATUS = "order_status"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    enum class OrderStatus(val value: Int, val title: String, val message: String) {
        CONFIRMED(1, "Order Confirmed", "Your order has been confirmed and will be prepared shortly."),
        PREPARING(2, "Order Being Prepared", "Your order is now being prepared by the restaurant."),
        ON_THE_WAY(3, "On The Way", "Your courier is on the way to deliver your order."),
        ARRIVING(4, "Almost There", "Your courier is arriving soon with your order!"),
        DELIVERED(5, "Order Delivered", "Your order has been delivered. Enjoy your meal!")
    }

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
            .putInt(KEY_ORDER_STATUS, OrderStatus.CONFIRMED.value)
            .apply()

        // Send notification for new order
        sendNotification(OrderStatus.CONFIRMED)

        // Start the tracking service
        startOrderTrackingService()
    }

    /**
     * Start the order tracking service
     */
    private fun startOrderTrackingService() {
        val serviceIntent = Intent(context, OrderTrackingService::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(serviceIntent)
        } else {
            context.startService(serviceIntent)
        }
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
     * Update the order status and send a notification
     */
    fun updateOrderStatus(status: OrderStatus) {
        if (!hasActiveOrder()) return

        val currentStatus = getCurrentOrderStatus()

        // Only update if it's a new status
        if (status.value > currentStatus.value) {
            prefs.edit()
                .putInt(KEY_ORDER_STATUS, status.value)
                .apply()

            sendNotification(status)
        }
    }

    /**
     * Get the current order status
     */
    fun getCurrentOrderStatus(): OrderStatus {
        val statusValue = prefs.getInt(KEY_ORDER_STATUS, OrderStatus.CONFIRMED.value)
        return OrderStatus.values().find { it.value == statusValue } ?: OrderStatus.CONFIRMED
    }

    /**
     * Send a notification for the given order status
     */
    private fun sendNotification(status: OrderStatus) {
        notificationService.showOrderStatusNotification(status.title, status.message)
    }

    /**
     * Complete the current order
     */
    fun completeOrder() {
        // Send delivered notification first
        sendNotification(OrderStatus.DELIVERED)

        prefs.edit()
            .putBoolean(KEY_ACTIVE_ORDER, false)
            .apply()

        // Stop the tracking service
        context.stopService(Intent(context, OrderTrackingService::class.java))
    }

    /**
     * Calculate the appropriate order status based on progress percentage
     */
    fun getStatusForProgress(progressPercentage: Int): OrderStatus {
        return when {
            progressPercentage < 25 -> OrderStatus.CONFIRMED
            progressPercentage < 50 -> OrderStatus.PREPARING
            progressPercentage < 75 -> OrderStatus.ON_THE_WAY
            progressPercentage < 100 -> OrderStatus.ARRIVING
            else -> OrderStatus.DELIVERED
        }
    }
}