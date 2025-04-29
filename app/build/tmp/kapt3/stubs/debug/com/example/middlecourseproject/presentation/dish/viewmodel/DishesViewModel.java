package com.example.middlecourseproject.presentation.dish.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0016H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/example/middlecourseproject/presentation/dish/viewmodel/DishesViewModel;", "Landroidx/lifecycle/ViewModel;", "getRestaurantByIdUseCase", "Lcom/example/middlecourseproject/domain/restaurant/usecase/GetRestaurantByIdUseCase;", "addToCartUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/AddToCartUseCase;", "getCartItemCountUseCase", "Lcom/example/middlecourseproject/domain/cart/usecase/GetCartItemCountUseCase;", "(Lcom/example/middlecourseproject/domain/restaurant/usecase/GetRestaurantByIdUseCase;Lcom/example/middlecourseproject/domain/cart/usecase/AddToCartUseCase;Lcom/example/middlecourseproject/domain/cart/usecase/GetCartItemCountUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/dish/viewmodel/DishesState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "addToCart", "", "dish", "Lcom/example/middlecourseproject/domain/restaurant/model/Dish;", "loadRestaurantDetails", "restaurantId", "", "observeCartCount", "showMessage", "message", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DishesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantByIdUseCase getRestaurantByIdUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.AddToCartUseCase addToCartUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.cart.usecase.GetCartItemCountUseCase getCartItemCountUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.dish.viewmodel.DishesState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.dish.viewmodel.DishesState> state = null;
    
    @javax.inject.Inject()
    public DishesViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantByIdUseCase getRestaurantByIdUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.AddToCartUseCase addToCartUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.usecase.GetCartItemCountUseCase getCartItemCountUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.dish.viewmodel.DishesState> getState() {
        return null;
    }
    
    private final void observeCartCount() {
    }
    
    public final void loadRestaurantDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String restaurantId) {
    }
    
    public final void addToCart(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.model.Dish dish) {
    }
    
    private final void showMessage(java.lang.String message) {
    }
}