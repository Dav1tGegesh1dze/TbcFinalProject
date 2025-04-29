package com.example.middlecourseproject.presentation.restaurant.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/example/middlecourseproject/presentation/restaurant/viewmodel/RestaurantViewModel;", "Landroidx/lifecycle/ViewModel;", "getCategoriesUseCase", "Lcom/example/middlecourseproject/domain/restaurant/usecase/GetCategoriesUseCase;", "getRestaurantsByCategoryUseCase", "Lcom/example/middlecourseproject/domain/restaurant/usecase/GetRestaurantsByCategoryUseCase;", "getAdBannersUseCase", "Lcom/example/middlecourseproject/domain/restaurant/usecase/GetAdBannersUseCase;", "(Lcom/example/middlecourseproject/domain/restaurant/usecase/GetCategoriesUseCase;Lcom/example/middlecourseproject/domain/restaurant/usecase/GetRestaurantsByCategoryUseCase;Lcom/example/middlecourseproject/domain/restaurant/usecase/GetAdBannersUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/restaurant/state/RestaurantState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadAdBanners", "", "loadCategories", "loadNearbyRestaurants", "latitude", "", "longitude", "loadRestaurants", "categoryId", "", "onEvent", "event", "Lcom/example/middlecourseproject/presentation/restaurant/event/RestaurantEvent;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RestaurantViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.restaurant.usecase.GetCategoriesUseCase getCategoriesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantsByCategoryUseCase getRestaurantsByCategoryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.restaurant.usecase.GetAdBannersUseCase getAdBannersUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.restaurant.state.RestaurantState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.restaurant.state.RestaurantState> state = null;
    
    @javax.inject.Inject()
    public RestaurantViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.usecase.GetCategoriesUseCase getCategoriesUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantsByCategoryUseCase getRestaurantsByCategoryUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.usecase.GetAdBannersUseCase getAdBannersUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.restaurant.state.RestaurantState> getState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.restaurant.event.RestaurantEvent event) {
    }
    
    private final void loadCategories() {
    }
    
    private final void loadAdBanners() {
    }
    
    private final void loadRestaurants(java.lang.String categoryId) {
    }
    
    private final void loadNearbyRestaurants(double latitude, double longitude) {
    }
}