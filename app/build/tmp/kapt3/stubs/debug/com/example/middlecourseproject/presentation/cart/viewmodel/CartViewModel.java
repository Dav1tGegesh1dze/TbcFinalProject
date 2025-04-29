package com.example.middlecourseproject.presentation.cart.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/middlecourseproject/presentation/cart/viewmodel/CartViewModel;", "Landroidx/lifecycle/ViewModel;", "getCartItemsUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/GetCartItemsUseCase;", "getCartTotalUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/GetCartTotalUseCase;", "updateCartItemQuantityUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/UpdateCartItemQuantityUseCase;", "removeFromCartUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/RemoveFromCartUseCase;", "clearCartUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/ClearCartUseCase;", "(Lcom/example/middlecourseproject/domain/cart/usecase/GetCartItemsUseCase;Lcom/example/middlecourseproject/domain/cart/usecase/GetCartTotalUseCase;Lcom/example/middlecourseproject/domain/cart/usecase/UpdateCartItemQuantityUseCase;Lcom/example/middlecourseproject/domain/cart/usecase/RemoveFromCartUseCase;Lcom/example/middlecourseproject/domain/cart/usecase/ClearCartUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/cart/viewmodel/CartState;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearCart", "", "decreaseQuantity", "dishId", "", "increaseQuantity", "loadCartData", "removeItem", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CartViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.GetCartItemsUseCase getCartItemsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.GetCartTotalUseCase getCartTotalUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.UpdateCartItemQuantityUseCase updateCartItemQuantityUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.RemoveFromCartUseCase removeFromCartUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.ClearCartUseCase clearCartUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.cart.viewmodel.CartState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.cart.viewmodel.CartState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @javax.inject.Inject()
    public CartViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.GetCartItemsUseCase getCartItemsUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.GetCartTotalUseCase getCartTotalUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.UpdateCartItemQuantityUseCase updateCartItemQuantityUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.RemoveFromCartUseCase removeFromCartUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.ClearCartUseCase clearCartUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.cart.viewmodel.CartState> getState() {
        return null;
    }
    
    private final void loadCartData() {
    }
    
    public final void increaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId) {
    }
    
    public final void decreaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId) {
    }
    
    public final void removeItem(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId) {
    }
    
    public final void clearCart() {
    }
}