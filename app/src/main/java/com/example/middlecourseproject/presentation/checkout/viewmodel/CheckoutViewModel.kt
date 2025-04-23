package com.example.middlecourseproject.presentation.checkout.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.cart.usecase.GetCartTotalUseCase
import com.example.middlecourseproject.domain.checkout.model.DeliveryAddress
import com.example.middlecourseproject.domain.checkout.model.PaymentMethod
import com.example.middlecourseproject.domain.checkout.usecase.GetDeliveryAddressUseCase
import com.example.middlecourseproject.domain.checkout.usecase.GetPaymentMethodUseCase
import com.example.middlecourseproject.domain.checkout.usecase.PlaceOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CheckoutState(
    val subtotal: Double = 0.0,
    val bagFee: Double = 0.40,
    val smallOrderFee: Double = 3.99,
    val serviceFee: Double = 1.25,
    val deliveryFee: Double = 3.99,
    val tip: Double = 0.0,
    val discount: Double = 0.0,
    val promoCode: String? = null,
    val total: Double = 0.0,
    val deliveryAddress: DeliveryAddress = DeliveryAddress(
        coordinates = "41°48'3.25188''N 44°46'41.83536''E",
        details = "Home\nEntrance / Staircase: Feradze street"
    ),
    val paymentMethod: PaymentMethod? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val orderPlaced: Boolean = false
)

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val getCartTotalUseCase: GetCartTotalUseCase,
    private val getDeliveryAddressUseCase: GetDeliveryAddressUseCase,
    private val getPaymentMethodUseCase: GetPaymentMethodUseCase,
    private val placeOrderUseCase: PlaceOrderUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CheckoutState(isLoading = true))
    val state: StateFlow<CheckoutState> = _state

    fun loadCartSummary() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true) }

                // Get cart total - collect the first value from the flow
                val subtotal = getCartTotalUseCase().first()

                // Get delivery address (mock for now)
                val deliveryAddress = getDeliveryAddressUseCase()

                // Get payment method if available
                val paymentMethod = getPaymentMethodUseCase()

                // Calculate total
                val total = calculateTotal(
                    subtotal = subtotal,
                    bagFee = _state.value.bagFee,
                    smallOrderFee = _state.value.smallOrderFee,
                    serviceFee = _state.value.serviceFee,
                    deliveryFee = _state.value.deliveryFee,
                    tip = _state.value.tip,
                    discount = _state.value.discount
                )

                // Update state
                _state.update { currentState ->
                    currentState.copy(
                        subtotal = subtotal,
                        deliveryAddress = deliveryAddress,
                        paymentMethod = paymentMethod,
                        total = total,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to load checkout information: ${e.message}"
                    )
                }
            }
        }
    }

    private fun calculateTotal(
        subtotal: Double,
        bagFee: Double,
        smallOrderFee: Double,
        serviceFee: Double,
        deliveryFee: Double,
        tip: Double,
        discount: Double = 0.0
    ): Double {
        return subtotal + bagFee + smallOrderFee + serviceFee + deliveryFee + tip - discount
    }

    fun setTip(amount: Double) {
        viewModelScope.launch {
            val newTotal = calculateTotal(
                _state.value.subtotal,
                _state.value.bagFee,
                _state.value.smallOrderFee,
                _state.value.serviceFee,
                _state.value.deliveryFee,
                amount,
                _state.value.discount
            )

            _state.update {
                it.copy(
                    tip = amount,
                    total = newTotal
                )
            }
        }
    }

    fun applyPromoCode(code: String) {
        viewModelScope.launch {
            try {
                if (code == "TBC10") {
                    val discount = 10.0
                    val newTotal = calculateTotal(
                        _state.value.subtotal,
                        _state.value.bagFee,
                        _state.value.smallOrderFee,
                        _state.value.serviceFee,
                        _state.value.deliveryFee,
                        _state.value.tip,
                        discount
                    )

                    _state.update {
                        it.copy(
                            discount = discount,
                            total = newTotal,
                            promoCode = code,
                            error = null
                        )
                    }
                } else {
                    _state.update {
                        it.copy(
                            error = "Invalid promo code"
                        )
                    }
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        error = "Failed to apply promo code: ${e.message}"
                    )
                }
            }
        }
    }

    fun updateDeliveryAddress(coordinates: String, details: String) {
        _state.update {
            it.copy(
                deliveryAddress = DeliveryAddress(
                    coordinates = coordinates,
                    details = details
                )
            )
        }
    }

    fun placeOrder() {
        viewModelScope.launch {
            try {
                _state.update { it.copy(isLoading = true) }

                // Validate order is ready
                if (_state.value.paymentMethod == null) {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = "Please add a payment method"
                        )
                    }
                    return@launch
                }

                // Place order
                placeOrderUseCase()

                // Update state on success
                _state.update {
                    it.copy(
                        isLoading = false,
                        orderPlaced = true
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to place order: ${e.message}"
                    )
                }
            }
        }
    }
}