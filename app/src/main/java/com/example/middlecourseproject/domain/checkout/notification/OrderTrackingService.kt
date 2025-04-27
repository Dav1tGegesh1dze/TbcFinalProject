package com.example.middlecourseproject.domain.checkout.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.middlecourseproject.R
import com.example.middlecourseproject.domain.checkout.manager.OrderManager
import com.example.middlecourseproject.presentation.base.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrderTrackingService : Service() {

    @Inject
    lateinit var orderManager: OrderManager

    private val handler = Handler(Looper.getMainLooper())
    private val updateIntervalMillis = 10000L
    private var lastStatusValue = -1

    companion object {
        private const val TAG = "OrderTrackingService"
        const val FOREGROUND_NOTIFICATION_ID = 1001
        const val STATUS_NOTIFICATION_ID = 1002
        const val CHANNEL_ID = "order_status_channel"
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service started")

        // Start service in foreground to keep it running
        startForeground(FOREGROUND_NOTIFICATION_ID, createForegroundNotification())

        // Start tracking if there's an active order
        if (orderManager.hasActiveOrder()) {
            startOrderTracking()
        } else {
            stopSelf()
        }

        return START_STICKY
    }

    private fun startOrderTracking() {
        val updateRunnable = object : Runnable {
            override fun run() {
                if (!orderManager.hasActiveOrder()) {
                    Log.d(TAG, "No active order, stopping service")
                    stopSelf()
                    return
                }

                // Calculate progress
                val orderStartTime = orderManager.getOrderPlacedTimeMillis()
                val orderEndTime = orderManager.getDeliveryTimeMillis()
                val currentTime = System.currentTimeMillis()
                val totalDuration = orderEndTime - orderStartTime
                val timeElapsed = currentTime - orderStartTime

                // Guard against division by zero or negative time
                if (totalDuration <= 0L) {
                    stopSelf()
                    return
                }

                val progress = ((timeElapsed.toFloat() / totalDuration.toFloat()) * 100).toInt()
                val orderStatus = orderManager.getStatusForProgress(progress)

                Log.d(TAG, "Progress: $progress%, Status: ${orderStatus.name}")

                // Check if status has changed
                if (orderStatus.value != lastStatusValue) {
                    // Update stored status
                    orderManager.updateOrderStatus(orderStatus)
                    lastStatusValue = orderStatus.value

                    // Send notification about the status change
                    sendStatusNotification(orderStatus.title, orderStatus.message)
                }

                // Check if order is complete
                if (progress >= 100) {
                    Log.d(TAG, "Order complete")
                    orderManager.completeOrder()
                    sendStatusNotification("Order Delivered", "Your order has been delivered. Enjoy your meal!")
                    stopSelf()
                    return
                }

                // Schedule next update
                handler.postDelayed(this, updateIntervalMillis)
            }
        }

        // Start the periodic updates
        handler.post(updateRunnable)
    }

    private fun createForegroundNotification(): Notification {
        val notificationIntent = Intent(this, MainActivity::class.java)
        notificationIntent.putExtra("navigate_to_order", true)

        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Order in Progress")
            .setContentText("Tracking your order...")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)
            .setSilent(true) // Don't make sound for this ongoing notification
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    private fun sendStatusNotification(title: String, message: String) {
        val notificationIntent = Intent(this, MainActivity::class.java)
        notificationIntent.putExtra("navigate_to_order", true)

        val pendingIntent = PendingIntent.getActivity(
            this, 1, notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(STATUS_NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Order Status Updates"
            val descriptionText = "Notifications for food delivery status updates"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
                enableVibration(true)
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
        Log.d(TAG, "Service destroyed")
    }
}