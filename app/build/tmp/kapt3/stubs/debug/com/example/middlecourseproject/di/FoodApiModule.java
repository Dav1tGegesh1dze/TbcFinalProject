package com.example.middlecourseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/middlecourseproject/di/FoodApiModule;", "", "()V", "provideDishService", "Lcom/example/middlecourseproject/data/remote/services/DishService;", "retrofit", "Lretrofit2/Retrofit;", "provideFoodRetrofit", "client", "Lokhttp3/OkHttpClient;", "provideFoodService", "Lcom/example/middlecourseproject/data/remote/services/FoodService;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class FoodApiModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.di.FoodApiModule INSTANCE = null;
    
    private FoodApiModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @FoodRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideFoodRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.remote.services.FoodService provideFoodService(@FoodRetrofit()
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.remote.services.DishService provideDishService(@FoodRetrofit()
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}