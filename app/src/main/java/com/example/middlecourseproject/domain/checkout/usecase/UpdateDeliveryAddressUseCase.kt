package com.example.middlecourseproject.domain.checkout.usecase

import com.example.middlecourseproject.domain.checkout.model.DeliveryAddress
import com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository
import javax.inject.Inject

class UpdateDeliveryAddressUseCase @Inject constructor(
    private val checkoutRepository: CheckoutRepository
) {
    suspend operator fun invoke(deliveryAddress: DeliveryAddress) {
        checkoutRepository.updateDeliveryAddress(deliveryAddress)
    }
}