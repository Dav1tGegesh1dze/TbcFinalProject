package com.example.middlecourseproject.domain.restaurant.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003H&J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\r"}, d2 = {"Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;", "", "getAdBanners", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/middlecourseproject/domain/restaurant/model/AdBanner;", "getAllRestaurants", "Lcom/example/middlecourseproject/domain/restaurant/model/Restaurant;", "getCategories", "Lcom/example/middlecourseproject/domain/restaurant/model/Category;", "getRestaurantsByCategory", "categoryId", "", "app_debug"})
public abstract interface RestaurantRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Category>> getCategories();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant>> getRestaurantsByCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String categoryId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant>> getAllRestaurants();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner>> getAdBanners();
}