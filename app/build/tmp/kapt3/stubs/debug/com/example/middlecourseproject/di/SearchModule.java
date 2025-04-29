package com.example.middlecourseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/middlecourseproject/di/SearchModule;", "", "()V", "provideSearchHelper", "Lcom/example/middlecourseproject/domain/search/SearchHelper;", "provideSearchUseCase", "Lcom/example/middlecourseproject/domain/search/usecase/SearchUseCase;", "restaurantRepository", "Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;", "searchHelper", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class SearchModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.di.SearchModule INSTANCE = null;
    
    private SearchModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.search.SearchHelper provideSearchHelper() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.search.usecase.SearchUseCase provideSearchUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository restaurantRepository, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.search.SearchHelper searchHelper) {
        return null;
    }
}