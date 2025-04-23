package com.example.middlecourseproject.domain.checkout.usecase

import com.example.middlecourseproject.domain.checkout.model.PaymentMethod
import com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository
import javax.inject.Inject

class GetPaymentMethodUseCase @Inject constructor(
    private val checkoutRepository: CheckoutRepository
) {
    suspend operator fun invoke(): PaymentMethod? {
        return checkoutRepository.getDefaultPaymentMethod()
    }
}