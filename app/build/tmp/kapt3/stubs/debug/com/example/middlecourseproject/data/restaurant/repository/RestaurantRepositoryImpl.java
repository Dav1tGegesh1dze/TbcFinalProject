package com.example.middlecourseproject.data.restaurant.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\tH\u0016J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\tH\u0016J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\tH\u0016J\u001e\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/middlecourseproject/data/restaurant/repository/RestaurantRepositoryImpl;", "Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;", "restaurantApi", "Lcom/example/middlecourseproject/data/restaurant/api/RestaurantApi;", "(Lcom/example/middlecourseproject/data/restaurant/api/RestaurantApi;)V", "createFallbackAdBanners", "", "Lcom/example/middlecourseproject/domain/restaurant/model/AdBanner;", "getAdBanners", "Lkotlinx/coroutines/flow/Flow;", "getAllRestaurants", "Lcom/example/middlecourseproject/domain/restaurant/model/Restaurant;", "getCategories", "Lcom/example/middlecourseproject/domain/restaurant/model/Category;", "getRestaurantsByCategory", "categoryId", "", "app_debug"})
public final class RestaurantRepositoryImpl implements com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.restaurant.api.RestaurantApi restaurantApi = null;
    
    @javax.inject.Inject()
    public RestaurantRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.api.RestaurantApi restaurantApi) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Category>> getCategories() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant>> getRestaurantsByCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String categoryId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant>> getAllRestaurants() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner>> getAdBanners() {
        return null;
    }
    
    private final java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner> createFallbackAdBanners() {
        return null;
    }
}