package com.example.middlecourseproject.di.checkout;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/example/middlecourseproject/di/checkout/CheckoutUseCasesModule;", "", "()V", "provideAddPaymentMethodUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/AddPaymentMethodUseCase;", "checkoutRepository", "Lcom/example/middlecourseproject/domain/checkout/repository/CheckoutRepository;", "provideGetDeliveryAddressUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/GetDeliveryAddressUseCase;", "provideGetPaymentMethodUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/GetPaymentMethodUseCase;", "providePlaceOrderUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/PlaceOrderUseCase;", "clearCartUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/ClearCartUseCase;", "provideUpdateDeliveryAddressUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/UpdateDeliveryAddressUseCase;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class CheckoutUseCasesModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.di.checkout.CheckoutUseCasesModule INSTANCE = null;
    
    private CheckoutUseCasesModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.usecase.GetDeliveryAddressUseCase provideGetDeliveryAddressUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository checkoutRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.usecase.UpdateDeliveryAddressUseCase provideUpdateDeliveryAddressUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository checkoutRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.usecase.GetPaymentMethodUseCase provideGetPaymentMethodUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository checkoutRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.usecase.AddPaymentMethodUseCase provideAddPaymentMethodUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository checkoutRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.usecase.PlaceOrderUseCase providePlaceOrderUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository checkoutRepository, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.ClearCartUseCase clearCartUseCase) {
        return null;
    }
}