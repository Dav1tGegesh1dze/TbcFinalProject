package com.example.middlecourseproject.domain.checkout.notification

import android.content.Intent
import android.util.Log
import com.example.middlecourseproject.domain.checkout.manager.OrderManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var notificationService: NotificationService

    @Inject
    lateinit var orderManager: OrderManager

    companion object {
        private const val TAG = "FCM_Service"
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")

        // Check if message contains data payload
        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")

            // Handle order status updates
            if (remoteMessage.data.containsKey("order_status")) {
                handleOrderStatusUpdate(remoteMessage.data)
            }
        }

        // Check if message contains notification payload
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Title: ${it.title}")
            Log.d(TAG, "Message Notification Body: ${it.body}")

            it.title?.let { title ->
                it.body?.let { body ->
                    notificationService.showOrderStatusNotification(title, body)
                }
            }
        }
    }

    private fun handleOrderStatusUpdate(data: Map<String, String>) {
        val statusValue = data["order_status"]?.toIntOrNull() ?: return

        // Only process if we have an active order
        if (orderManager.hasActiveOrder()) {
            try {
                // Find the order status enum by value
                val status = OrderManager.OrderStatus.values()
                    .find { it.value == statusValue } ?: return

                // Update the order status
                orderManager.updateOrderStatus(status)

                // Broadcast intent to update UI if app is in foreground
                val intent = Intent("com.example.middlecourseproject.ORDER_STATUS_UPDATED")
                intent.putExtra("status_value", statusValue)
                sendBroadcast(intent)

            } catch (e: Exception) {
                Log.e(TAG, "Error handling order status update", e)
            }
        }
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        // Send the token to your server if needed
        // You could store this in SharedPreferences or send to your backend
    }
}