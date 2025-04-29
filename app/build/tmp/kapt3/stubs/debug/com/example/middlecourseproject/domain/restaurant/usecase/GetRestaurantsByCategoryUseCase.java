package com.example.middlecourseproject.domain.restaurant.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/middlecourseproject/domain/restaurant/usecase/GetRestaurantsByCategoryUseCase;", "", "repository", "Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;", "(Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/middlecourseproject/domain/restaurant/model/Restaurant;", "categoryId", "", "app_debug"})
public final class GetRestaurantsByCategoryUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository repository = null;
    
    @javax.inject.Inject()
    public GetRestaurantsByCategoryUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant>> invoke(@org.jetbrains.annotations.Nullable()
    java.lang.String categoryId) {
        return null;
    }
}