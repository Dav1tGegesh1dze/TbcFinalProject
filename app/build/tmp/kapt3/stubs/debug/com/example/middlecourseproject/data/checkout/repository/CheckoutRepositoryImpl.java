package com.example.middlecourseproject.data.checkout.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/middlecourseproject/data/checkout/repository/CheckoutRepositoryImpl;", "Lcom/example/middlecourseproject/domain/checkout/repository/CheckoutRepository;", "context", "Landroid/content/Context;", "cartRepository", "Lcom/example/middlecourseproject/domain/cart/repository/CartRepository;", "json", "Lkotlinx/serialization/json/Json;", "(Landroid/content/Context;Lcom/example/middlecourseproject/domain/cart/repository/CartRepository;Lkotlinx/serialization/json/Json;)V", "addPaymentMethod", "", "paymentMethod", "Lcom/example/middlecourseproject/domain/checkout/model/PaymentMethod;", "setAsDefault", "", "(Lcom/example/middlecourseproject/domain/checkout/model/PaymentMethod;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultPaymentMethod", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeliveryAddress", "Lcom/example/middlecourseproject/domain/checkout/model/DeliveryAddress;", "placeOrder", "", "updateDeliveryAddress", "deliveryAddress", "(Lcom/example/middlecourseproject/domain/checkout/model/DeliveryAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreferencesKeys", "app_debug"})
public final class CheckoutRepositoryImpl implements com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.repository.CartRepository cartRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.serialization.json.Json json = null;
    
    @javax.inject.Inject()
    public CheckoutRepositoryImpl(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.repository.CartRepository cartRepository, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.json.Json json) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDeliveryAddress(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.middlecourseproject.domain.checkout.model.DeliveryAddress> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateDeliveryAddress(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.model.DeliveryAddress deliveryAddress, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDefaultPaymentMethod(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.middlecourseproject.domain.checkout.model.PaymentMethod> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addPaymentMethod(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.model.PaymentMethod paymentMethod, boolean setAsDefault, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object placeOrder(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/middlecourseproject/data/checkout/repository/CheckoutRepositoryImpl$PreferencesKeys;", "", "()V", "DEFAULT_PAYMENT_METHOD", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getDEFAULT_PAYMENT_METHOD", "()Landroidx/datastore/preferences/core/Preferences$Key;", "DELIVERY_ADDRESS", "getDELIVERY_ADDRESS", "PAYMENT_METHODS", "getPAYMENT_METHODS", "app_debug"})
    static final class PreferencesKeys {
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> DELIVERY_ADDRESS = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> DEFAULT_PAYMENT_METHOD = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> PAYMENT_METHODS = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.example.middlecourseproject.data.checkout.repository.CheckoutRepositoryImpl.PreferencesKeys INSTANCE = null;
        
        private PreferencesKeys() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getDELIVERY_ADDRESS() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getDEFAULT_PAYMENT_METHOD() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getPAYMENT_METHODS() {
            return null;
        }
    }
}