package com.example.middlecourseproject.presentation.checkout.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.middlecourseproject.R
import com.example.middlecourseproject.domain.checkout.manager.OrderManager
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@AndroidEntryPoint
class OrderConfirmationFragment : Fragment() {
    @Inject
    lateinit var orderManager: OrderManager

    private var countDownTimer: CountDownTimer? = null
    private var deliveryTimeMillis: Long = 0
    private var isNewOrder = false
    private var lastOrderStatus = -1


    private var estimatedDeliveryTime by mutableStateOf("00:00")
    private var remainingTime by mutableStateOf("00:00")
    private var orderTrackingMessage by mutableStateOf("")
    private var orderProgress by mutableStateOf(0)
    private var deliveryAddress by mutableStateOf("Feradze Street, 9b")
    private var currentStage by mutableStateOf(1)


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
        requireContext().registerReceiver(
            statusUpdateReceiver,
            IntentFilter("com.example.middlecourseproject.ORDER_STATUS_UPDATED"),
            Context.RECEIVER_NOT_EXPORTED
        )
    }

    override fun onStop() {
        super.onStop()
        requireContext().unregisterReceiver(statusUpdateReceiver)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MaterialTheme {
                    OrderConfirmationScreen()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkExistingOrder()
    }

    override fun onDestroyView() {
        countDownTimer?.cancel()
        super.onDestroyView()
    }

    private fun continueShoppingClicked() {
        findNavController().navigate(R.id.action_orderConfirmationFragment_to_restaurantFragment)
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
        deliveryTimeMillis = orderManager.getDeliveryTimeMillis()
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = deliveryTimeMillis

        val deliveryHour = calendar.get(Calendar.HOUR_OF_DAY)
        val deliveryMinute = calendar.get(Calendar.MINUTE)

        val formattedTime = String.format("%02d:%02d", deliveryHour, deliveryMinute)
        estimatedDeliveryTime = formattedTime

        deliveryAddress = orderManager.getDeliveryAddress()

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
        estimatedDeliveryTime = formattedTime

        val address = "Feradze Street, 9b"
        deliveryAddress = address

        orderManager.createOrder(45, address)
    }

    private fun startOrderTracking() {
        val currentTimeMillis = System.currentTimeMillis()
        val timeUntilDelivery = deliveryTimeMillis - currentTimeMillis

        if (timeUntilDelivery <= 0) {
            orderTrackingMessage = "Your order has been delivered. Enjoy your meal!"
            estimatedDeliveryTime = "Delivered"
            remainingTime = "00:00"
            orderProgress = 100
            currentStage = 4
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
                orderTrackingMessage = "Your order has been delivered. Enjoy your meal!"
                estimatedDeliveryTime = "Delivered"
                remainingTime = "00:00"
                orderProgress = 100
                currentStage = 4

                orderManager.completeOrder()
            }
        }.start()
    }

    private fun updateRemainingTime(millisUntilFinished: Long) {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
        remainingTime = String.format("%02d:%02d", minutes, seconds)
    }

    private fun updateOrderStatus(totalTime: Long, remainingTime: Long) {
        val progress = (1 - (remainingTime.toFloat() / totalTime.toFloat())) * 100
        val progressInt = progress.toInt()

        orderProgress = progressInt


        val orderStatus = orderManager.getStatusForProgress(progressInt)


        orderTrackingMessage = orderStatus.message
        currentStage = orderStatus.value


        if (orderStatus.value != lastOrderStatus) {
            orderManager.updateOrderStatus(orderStatus)
            lastOrderStatus = orderStatus.value
        }
    }

    private fun updateUIForStatus(statusValue: Int) {
        val status = OrderManager.OrderStatus.values()
            .find { it.value == statusValue } ?: OrderManager.OrderStatus.CONFIRMED

        orderTrackingMessage = status.message
        currentStage = status.value
        lastOrderStatus = status.value

        orderProgress = when (statusValue) {
            1 -> 20   // CONFIRMED
            2 -> 40   // PREPARING
            3 -> 60   // ON_THE_WAY
            4 -> 80   // ARRIVING
            5 -> 100  // DELIVERED
            else -> 0
        }


        if (statusValue == 5) {
            estimatedDeliveryTime = "Delivered"
            this.remainingTime = "00:00"

            countDownTimer?.cancel()
        }
    }

    private fun resetOrderStatusIndicators() {
        currentStage = 1
    }

    @Composable
    fun OrderConfirmationScreen() {
        val backgroundColor = colorResource(id = R.color.color_background_category)
        val accentColor = Color(0xFF00BFFF)
        val orangeColor = Color(0xFFFF5722)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(36.dp))

            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Success",
                modifier = Modifier.size(120.dp),
                tint = accentColor
            )

            Text(
                text = "Order Confirmed!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp)
            )

            Text(
                text = "Thank you for your order",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Estimated Delivery",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = estimatedDeliveryTime,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = accentColor
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Arriving in:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Text(
                            text = remainingTime,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = orangeColor
                        )
                    }

                    Text(
                        text = orderTrackingMessage,
                        modifier = Modifier.padding(top = 16.dp)
                    )

                    LinearProgressIndicator(
                        progress = orderProgress / 100f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        color = accentColor
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        OrderStageText(
                            text = "Confirmed",
                            isActive = currentStage >= 1,
                            accentColor = accentColor
                        )
                        OrderStageText(
                            text = "Preparing",
                            isActive = currentStage >= 2,
                            accentColor = accentColor
                        )
                        OrderStageText(
                            text = "On the way",
                            isActive = currentStage >= 3,
                            accentColor = accentColor
                        )
                        OrderStageText(
                            text = "Arriving",
                            isActive = currentStage >= 4,
                            accentColor = accentColor
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Delivery Address",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = deliveryAddress,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }

            OutlinedButton(
                onClick = { continueShoppingClicked() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(text = "Continue Shopping")
            }
        }
    }

    @Composable
    fun RowScope.OrderStageText(text: String, isActive: Boolean, accentColor: Color) {
        Text(
            text = text,
            fontSize = 12.sp,
            color = if (isActive) accentColor else Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
    }
}