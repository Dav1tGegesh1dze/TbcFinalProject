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

        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")

            if (remoteMessage.data.containsKey("order_status")) {
                handleOrderStatusUpdate(remoteMessage.data)
            }
        }

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

        if (orderManager.hasActiveOrder()) {
            try {
                val status = OrderManager.OrderStatus.values()
                    .find { it.value == statusValue } ?: return

                orderManager.updateOrderStatus(status)

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
    }
}