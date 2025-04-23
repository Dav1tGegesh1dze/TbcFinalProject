package com.example.middlecourseproject.domain.checkout.usecase

import com.example.middlecourseproject.domain.checkout.model.PaymentMethod
import com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository
import javax.inject.Inject

class AddPaymentMethodUseCase @Inject constructor(
    private val checkoutRepository: CheckoutRepository
) {
    suspend operator fun invoke(paymentMethod: PaymentMethod, setAsDefault: Boolean = true) {
        checkoutRepository.addPaymentMethod(paymentMethod, setAsDefault)
    }
}