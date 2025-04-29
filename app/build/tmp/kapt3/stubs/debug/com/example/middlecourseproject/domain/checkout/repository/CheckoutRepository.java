package com.example.middlecourseproject.domain.checkout.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u00a6@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/repository/CheckoutRepository;", "", "addPaymentMethod", "", "paymentMethod", "Lcom/example/middlecourseproject/domain/checkout/model/PaymentMethod;", "setAsDefault", "", "(Lcom/example/middlecourseproject/domain/checkout/model/PaymentMethod;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultPaymentMethod", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeliveryAddress", "Lcom/example/middlecourseproject/domain/checkout/model/DeliveryAddress;", "placeOrder", "", "updateDeliveryAddress", "deliveryAddress", "(Lcom/example/middlecourseproject/domain/checkout/model/DeliveryAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CheckoutRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDeliveryAddress(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.middlecourseproject.domain.checkout.model.DeliveryAddress> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDeliveryAddress(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.model.DeliveryAddress deliveryAddress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDefaultPaymentMethod(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.middlecourseproject.domain.checkout.model.PaymentMethod> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addPaymentMethod(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.model.PaymentMethod paymentMethod, boolean setAsDefault, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object placeOrder(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}