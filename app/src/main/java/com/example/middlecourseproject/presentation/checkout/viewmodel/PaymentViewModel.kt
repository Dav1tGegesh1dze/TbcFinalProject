package com.example.middlecourseproject.presentation.checkout.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.middlecourseproject.domain.checkout.model.CardType
import com.example.middlecourseproject.domain.checkout.model.PaymentMethod
import com.example.middlecourseproject.domain.checkout.usecase.AddPaymentMethodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

data class PaymentState(
    val cardNumberError: String? = null,
    val expiryDateError: String? = null,
    val cvvError: String? = null,
    val cardholderNameError: String? = null,
    val cardAdded: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val addPaymentMethodUseCase: AddPaymentMethodUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PaymentState())
    val state: StateFlow<PaymentState> = _state

    fun addCard(cardNumber: String, expiryDate: String, cvv: String, cardholderName: String) {
        viewModelScope.launch {
            try {
                _state.update {
                    it.copy(
                        isLoading = true,
                        cardNumberError = null,
                        expiryDateError = null,
                        cvvError = null,
                        cardholderNameError = null,
                        error = null
                    )
                }

                // Validate input
                val validationResult = validateCardInput(cardNumber, expiryDate, cvv, cardholderName)

                if (!validationResult.isValid) {
                    _state.update {
                        it.copy(
                            cardNumberError = validationResult.cardNumberError,
                            expiryDateError = validationResult.expiryDateError,
                            cvvError = validationResult.cvvError,
                            cardholderNameError = validationResult.cardholderNameError,
                            isLoading = false
                        )
                    }
                    return@launch
                }

                // Create payment method
                val cardType = detectCardType(cardNumber)
                val lastFour = cardNumber.takeLast(4)
                val (expiryMonth, expiryYear) = parseExpiryDate(expiryDate)

                val paymentMethod = PaymentMethod(
                    id = UUID.randomUUID().toString(),
                    cardType = cardType,
                    lastFour = lastFour,
                    expiryMonth = expiryMonth,
                    expiryYear = expiryYear,
                    cardholderName = cardholderName
                )

                // Add payment method
                addPaymentMethodUseCase(paymentMethod, true)

                // Update state
                _state.update {
                    it.copy(
                        isLoading = false,
                        cardAdded = true
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to add payment method: ${e.message}"
                    )
                }
            }
        }
    }

    private fun validateCardInput(
        cardNumber: String,
        expiryDate: String,
        cvv: String,
        cardholderName: String
    ): ValidationResult {
        val result = ValidationResult()

        // Validate card number
        if (cardNumber.isEmpty()) {
            result.cardNumberError = "Card number is required"
        } else if (cardNumber.length < 13 || cardNumber.length > 19) {
            result.cardNumberError = "Invalid card number"
        } else if (!cardNumber.all { it.isDigit() }) {
            result.cardNumberError = "Card number should contain only digits"
        } else if (!isValidLuhn(cardNumber)) {
            result.cardNumberError = "Invalid card number"
        }

        // Validate expiry date
        if (expiryDate.isEmpty()) {
            result.expiryDateError = "Expiry date is required"
        } else if (!expiryDate.matches(Regex("^(0[1-9]|1[0-2])/([0-9]{2})$"))) {
            result.expiryDateError = "Invalid format. Use MM/YY"
        } else {
            val (month, year) = parseExpiryDate(expiryDate)
            val currentYear = (java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) % 100)
            val currentMonth = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1

            if (year < currentYear || (year == currentYear && month < currentMonth)) {
                result.expiryDateError = "Card has expired"
            }
        }

        // Validate CVV
        if (cvv.isEmpty()) {
            result.cvvError = "CVV is required"
        } else if (!cvv.all { it.isDigit() }) {
            result.cvvError = "CVV should contain only digits"
        } else if (cvv.length < 3 || cvv.length > 4) {
            result.cvvError = "CVV should be 3 or 4 digits"
        }

        // Validate cardholder name
        if (cardholderName.isEmpty()) {
            result.cardholderNameError = "Cardholder name is required"
        }

        return result
    }

    private fun parseExpiryDate(expiryDate: String): Pair<Int, Int> {
        val parts = expiryDate.split("/")
        val month = parts[0].toInt()
        val year = parts[1].toInt()
        return Pair(month, year)
    }

    private fun detectCardType(cardNumber: String): CardType {
        return when {
            cardNumber.startsWith("4") -> CardType.VISA
            cardNumber.startsWith("5") -> CardType.MASTERCARD
            cardNumber.startsWith("3") -> CardType.AMERICAN_EXPRESS
            else -> CardType.UNKNOWN
        }
    }

    // Luhn algorithm for credit card validation
    private fun isValidLuhn(cardNumber: String): Boolean {
        var sum = 0
        var alternate = false
        for (i in cardNumber.length - 1 downTo 0) {
            var n = cardNumber[i].toString().toInt()
            if (alternate) {
                n *= 2
                if (n > 9) {
                    n = n % 10 + 1
                }
            }
            sum += n
            alternate = !alternate
        }
        return sum % 10 == 0
    }

    data class ValidationResult(
        var cardNumberError: String? = null,
        var expiryDateError: String? = null,
        var cvvError: String? = null,
        var cardholderNameError: String? = null
    ) {
        val isValid: Boolean
            get() = cardNumberError == null && expiryDateError == null &&
                    cvvError == null && cardholderNameError == null
    }
}