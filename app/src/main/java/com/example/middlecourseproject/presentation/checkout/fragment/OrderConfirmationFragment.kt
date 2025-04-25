package com.example.middlecourseproject.presentation.checkout.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.CountDownTimer
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.databinding.FragmentOrderConfirmationBinding
import com.example.middlecourseproject.domain.checkout.manager.OrderManager
import com.example.middlecourseproject.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class OrderConfirmationFragment : BaseFragment<FragmentOrderConfirmationBinding>(
    FragmentOrderConfirmationBinding::inflate
) {
    @Inject
    lateinit var orderManager: OrderManager

    private var countDownTimer: CountDownTimer? = null
    private var deliveryTimeMillis: Long = 0
    private var isNewOrder = false
    private var lastOrderStatus = -1

    // This receiver would get updates from our background service if needed
    private val statusUpdateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == "com.example.middlecourseproject.ORDER_STATUS_UPDATED") {
                val statusValue = intent.getIntExtra("status_value", -1)
                if (statusValue > 0) {
                    updateUIForStatus(statusValue)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        // Register for updates from background service
        requireContext().registerReceiver(
            statusUpdateReceiver,
            IntentFilter("com.example.middlecourseproject.ORDER_STATUS_UPDATED"),
            Context.RECEIVER_NOT_EXPORTED
        )
    }

    override fun onStop() {
        super.onStop()
        // Unregister when fragment is not visible
        requireContext().unregisterReceiver(statusUpdateReceiver)
    }

    override fun start() {
        setupListeners()
        checkExistingOrder()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        countDownTimer?.cancel()
    }

    private fun setupListeners() {
        binding.btnContinueShopping.setOnClickListener {
            // Continue shopping, coming back to restaurant
            findNavController().navigate(R.id.action_orderConfirmationFragment_to_restaurantFragment)
        }
    }

    private fun checkExistingOrder() {
        if (orderManager.hasActiveOrder()) {
            loadExistingOrder()
        } else {
            isNewOrder = true
            setupDeliveryTime()
            startOrderTracking()
        }
    }

    private fun loadExistingOrder() {
        //delivery time and date
        deliveryTimeMillis = orderManager.getDeliveryTimeMillis()
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = deliveryTimeMillis

        val deliveryHour = calendar.get(Calendar.HOUR_OF_DAY)
        val deliveryMinute = calendar.get(Calendar.MINUTE)

        val formattedTime = String.format("%02d:%02d", deliveryHour, deliveryMinute)
        binding.tvEstimatedDeliveryTime.text = formattedTime

        binding.tvDeliveryAddress.text = orderManager.getDeliveryAddress()

        // Update UI to current status
        val currentStatus = orderManager.getCurrentOrderStatus()
        updateUIForStatus(currentStatus.value)

        startOrderTracking()
    }

    private fun setupDeliveryTime() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MINUTE, 45)

        deliveryTimeMillis = calendar.timeInMillis

        val deliveryHour = calendar.get(Calendar.HOUR_OF_DAY)
        val deliveryMinute = calendar.get(Calendar.MINUTE)
        val formattedTime = String.format("%02d:%02d", deliveryHour, deliveryMinute)
        binding.tvEstimatedDeliveryTime.text = formattedTime

        val address = "Feradze Street, 9b"
        binding.tvDeliveryAddress.text = address

        orderManager.createOrder(45, address)
    }

    private fun startOrderTracking() {
        val currentTimeMillis = System.currentTimeMillis()
        val timeUntilDelivery = deliveryTimeMillis - currentTimeMillis

        // Don't start tracking if already delivered
        if (timeUntilDelivery <= 0) {
            binding.tvOrderTracking.text = "Your order has been delivered. Enjoy your meal!"
            binding.tvEstimatedDeliveryTime.text = "Delivered"
            binding.tvRemainingTime.text = "00:00"
            binding.orderProgressBar.progress = 100
            updateStageIndicators(4)
            return
        }

        resetOrderStatusIndicators()
        lastOrderStatus = orderManager.getCurrentOrderStatus().value

        countDownTimer = object : CountDownTimer(timeUntilDelivery, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                updateRemainingTime(millisUntilFinished)
                updateOrderStatus(
                    deliveryTimeMillis - orderManager.getOrderPlacedTimeMillis(),
                    millisUntilFinished
                )
            }

            override fun onFinish() {
                binding.tvOrderTracking.text = "Your order has been delivered. Enjoy your meal!"
                binding.tvEstimatedDeliveryTime.text = "Delivered"
                binding.tvRemainingTime.text = "00:00"
                binding.orderProgressBar.progress = 100

                updateStageIndicators(4) // 4 means all stages are complete

                orderManager.completeOrder()
            }
        }.start()
    }

    private fun updateRemainingTime(millisUntilFinished: Long) {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
        binding.tvRemainingTime.text = String.format("%02d:%02d", minutes, seconds)
    }

    private fun updateOrderStatus(totalTime: Long, remainingTime: Long) {
        val progress = (1 - (remainingTime.toFloat() / totalTime.toFloat())) * 100
        val progressInt = progress.toInt()

        binding.orderProgressBar.progress = progressInt

        // Get appropriate status for this progress point
        val orderStatus = orderManager.getStatusForProgress(progressInt)

        //show progresses, Where is delivering at that moment
        binding.tvOrderTracking.text = orderStatus.message
        updateStageIndicators(orderStatus.value)

        // Check if status has changed to trigger notification (but not on every tick)
        if (orderStatus.value != lastOrderStatus) {
            orderManager.updateOrderStatus(orderStatus)
            lastOrderStatus = orderStatus.value
        }
    }

    private fun updateUIForStatus(statusValue: Int) {
        // Find the status enum from value
        val status = OrderManager.OrderStatus.values()
            .find { it.value == statusValue } ?: OrderManager.OrderStatus.CONFIRMED

        // Update UI elements
        binding.tvOrderTracking.text = status.message
        updateStageIndicators(status.value)
        lastOrderStatus = status.value

        // Update progress bar based on status
        val progress = when (statusValue) {
            1 -> 20   // CONFIRMED
            2 -> 40   // PREPARING
            3 -> 60   // ON_THE_WAY
            4 -> 80   // ARRIVING
            5 -> 100  // DELIVERED
            else -> 0
        }

        binding.orderProgressBar.progress = progress

        // If delivered, update time display
        if (statusValue == 5) {
            binding.tvEstimatedDeliveryTime.text = "Delivered"
            binding.tvRemainingTime.text = "00:00"

            // Cancel countdown timer if it's still running
            countDownTimer?.cancel()
        }
    }

    private fun resetOrderStatusIndicators() {
        binding.tvStageConfirmed.setTextColor(resources.getColor(android.R.color.darker_gray, null))
        binding.tvStagePreparing.setTextColor(resources.getColor(android.R.color.darker_gray, null))
        binding.tvStageOnTheWay.setTextColor(resources.getColor(android.R.color.darker_gray, null))
        binding.tvStageArriving.setTextColor(resources.getColor(android.R.color.darker_gray, null))
    }

    private fun updateStageIndicators(currentStage: Int) {
        resetOrderStatusIndicators()

        // completed stages
        val activeColor = resources.getColor(R.color.activeStatus, null)

        if (currentStage >= 1) {
            binding.tvStageConfirmed.setTextColor(activeColor)
        }
        if (currentStage >= 2) {
            binding.tvStagePreparing.setTextColor(activeColor)
        }
        if (currentStage >= 3) {
            binding.tvStageOnTheWay.setTextColor(activeColor)
        }
        if (currentStage >= 4) {
            binding.tvStageArriving.setTextColor(activeColor)
        }
    }
}