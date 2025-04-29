package com.example.middlecourseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/middlecourseproject/di/AuthApiModule;", "", "()V", "provideAuthRetrofit", "Lretrofit2/Retrofit;", "client", "Lokhttp3/OkHttpClient;", "provideAuthService", "Lcom/example/middlecourseproject/data/remote/services/AuthService;", "retrofit", "provideProfileService", "Lcom/example/middlecourseproject/data/remote/services/ProfileService;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AuthApiModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.di.AuthApiModule INSTANCE = null;
    
    private AuthApiModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @AuthRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideAuthRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.remote.services.AuthService provideAuthService(@AuthRetrofit()
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.remote.services.ProfileService provideProfileService(@AuthRetrofit()
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}