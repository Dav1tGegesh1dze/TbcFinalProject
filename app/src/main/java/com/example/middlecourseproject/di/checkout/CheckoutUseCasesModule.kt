package com.example.middlecourseproject.di.checkout

import com.example.middlecourseproject.domain.cart.usecase.ClearCartUseCase
import com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository
import com.example.middlecourseproject.domain.checkout.usecase.AddPaymentMethodUseCase
import com.example.middlecourseproject.domain.checkout.usecase.GetDeliveryAddressUseCase
import com.example.middlecourseproject.domain.checkout.usecase.GetPaymentMethodUseCase
import com.example.middlecourseproject.domain.checkout.usecase.PlaceOrderUseCase
import com.example.middlecourseproject.domain.checkout.usecase.UpdateDeliveryAddressUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CheckoutUseCasesModule {

    @Provides
    @Singleton
    fun provideGetDeliveryAddressUseCase(checkoutRepository: CheckoutRepository): GetDeliveryAddressUseCase {
        return GetDeliveryAddressUseCase(checkoutRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateDeliveryAddressUseCase(checkoutRepository: CheckoutRepository): UpdateDeliveryAddressUseCase {
        return UpdateDeliveryAddressUseCase(checkoutRepository)
    }

    @Provides
    @Singleton
    fun provideGetPaymentMethodUseCase(checkoutRepository: CheckoutRepository): GetPaymentMethodUseCase {
        return GetPaymentMethodUseCase(checkoutRepository)
    }

    @Provides
    @Singleton
    fun provideAddPaymentMethodUseCase(checkoutRepository: CheckoutRepository): AddPaymentMethodUseCase {
        return AddPaymentMethodUseCase(checkoutRepository)
    }

    @Provides
    @Singleton
    fun providePlaceOrderUseCase(
        checkoutRepository: CheckoutRepository,
        clearCartUseCase: ClearCartUseCase
    ): PlaceOrderUseCase {
        return PlaceOrderUseCase(checkoutRepository, clearCartUseCase)
    }
}