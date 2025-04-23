package com.example.middlecourseproject.presentation.checkout.fragment

import android.os.CountDownTimer
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

        resetOrderStatusIndicators()

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

        binding.orderProgressBar.progress = progress.toInt()

        //show progresses, Where is delivering at that moment
        when {
            progress < 25 -> {
                binding.tvOrderTracking.text =
                    "Your order has been confirmed and will be prepared shortly."
                updateStageIndicators(1)
            }

            progress < 50 -> {
                binding.tvOrderTracking.text = "Your order is now being prepared by the restaurant."
                updateStageIndicators(2)
            }

            progress < 75 -> {
                binding.tvOrderTracking.text = "Your courier is on the way to deliver your order."
                updateStageIndicators(3)
            }

            else -> {
                binding.tvOrderTracking.text = "Your courier is arriving soon with your order!"
                updateStageIndicators(4)
            }
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