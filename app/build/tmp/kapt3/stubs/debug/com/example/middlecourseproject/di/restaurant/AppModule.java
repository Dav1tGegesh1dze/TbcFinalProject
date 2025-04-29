package com.example.middlecourseproject.di.restaurant;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/middlecourseproject/di/restaurant/AppModule;", "", "()V", "BASE_URL", "", "provideNotificationService", "Lcom/example/middlecourseproject/domain/checkout/notification/NotificationService;", "context", "Landroid/content/Context;", "provideOrderManager", "Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "notificationService", "provideRestaurantApi", "Lcom/example/middlecourseproject/data/restaurant/api/RestaurantApi;", "retrofitClient", "Lcom/example/middlecourseproject/data/restaurant/api/RetrofitClient;", "provideRestaurantRepository", "Lcom/example/middlecourseproject/domain/restaurant/repository/RestaurantRepository;", "api", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://run.mocky.io/v3/";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.di.restaurant.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.api.RestaurantApi provideRestaurantApi(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.api.RetrofitClient retrofitClient) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.restaurant.repository.RestaurantRepository provideRestaurantRepository(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.api.RestaurantApi api) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.notification.NotificationService provideNotificationService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.manager.OrderManager provideOrderManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.notification.NotificationService notificationService) {
        return null;
    }
}