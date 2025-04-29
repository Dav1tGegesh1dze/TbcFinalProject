package com.example.middlecourseproject.presentation.checkout.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015JB\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u0017H\u0002J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0017J\u0016\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006&"}, d2 = {"Lcom/example/middlecourseproject/presentation/checkout/viewmodel/CheckoutViewModel;", "Landroidx/lifecycle/ViewModel;", "getCartTotalUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/GetCartTotalUseCase;", "getDeliveryAddressUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/GetDeliveryAddressUseCase;", "getPaymentMethodUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/GetPaymentMethodUseCase;", "placeOrderUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/PlaceOrderUseCase;", "(Lcom/example/middlecourseproject/domain/cart/usecase/GetCartTotalUseCase;Lcom/example/middlecourseproject/domain/checkout/usecase/GetDeliveryAddressUseCase;Lcom/example/middlecourseproject/domain/checkout/usecase/GetPaymentMethodUseCase;Lcom/example/middlecourseproject/domain/checkout/usecase/PlaceOrderUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/checkout/viewmodel/CheckoutState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "applyPromoCode", "", "code", "", "calculateTotal", "", "subtotal", "bagFee", "smallOrderFee", "serviceFee", "deliveryFee", "tip", "discount", "loadCartSummary", "placeOrder", "setTip", "amount", "updateDeliveryAddress", "coordinates", "details", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CheckoutViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.GetCartTotalUseCase getCartTotalUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.checkout.usecase.GetDeliveryAddressUseCase getDeliveryAddressUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.checkout.usecase.GetPaymentMethodUseCase getPaymentMethodUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.checkout.usecase.PlaceOrderUseCase placeOrderUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.checkout.viewmodel.CheckoutState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.checkout.viewmodel.CheckoutState> state = null;
    
    @javax.inject.Inject()
    public CheckoutViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.GetCartTotalUseCase getCartTotalUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.usecase.GetDeliveryAddressUseCase getDeliveryAddressUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.usecase.GetPaymentMethodUseCase getPaymentMethodUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.usecase.PlaceOrderUseCase placeOrderUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.checkout.viewmodel.CheckoutState> getState() {
        return null;
    }
    
    public final void loadCartSummary() {
    }
    
    private final double calculateTotal(double subtotal, double bagFee, double smallOrderFee, double serviceFee, double deliveryFee, double tip, double discount) {
        return 0.0;
    }
    
    public final void setTip(double amount) {
    }
    
    public final void applyPromoCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    public final void updateDeliveryAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String coordinates, @org.jetbrains.annotations.NotNull()
    java.lang.String details) {
    }
    
    public final void placeOrder() {
    }
}