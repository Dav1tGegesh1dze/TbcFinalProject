package com.example.middlecourseproject.domain.search.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/middlecourseproject/domain/search/usecase/SearchUseCase;", "", "restaurantRepository", "Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;", "searchHelper", "Lcom/example/middlecourseproject/domain/search/SearchHelper;", "(Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;Lcom/example/middlecourseproject/domain/search/SearchHelper;)V", "getPopularSearchTerms", "Lkotlinx/coroutines/flow/Flow;", "", "", "searchRestaurants", "Lcom/example/middlecourseproject/domain/restaurant/model/Restaurant;", "query", "app_debug"})
public final class SearchUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository restaurantRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.search.SearchHelper searchHelper = null;
    
    @javax.inject.Inject()
    public SearchUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository restaurantRepository, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.search.SearchHelper searchHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getPopularSearchTerms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant>> searchRestaurants(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
}