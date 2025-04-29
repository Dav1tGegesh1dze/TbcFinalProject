package com.example.middlecourseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\'\u00a8\u0006\u0017"}, d2 = {"Lcom/example/middlecourseproject/di/RepositoryModule;", "", "()V", "bindAuthRepository", "Lcom/example/middlecourseproject/domain/repository/AuthRepository;", "authRepositoryImpl", "Lcom/example/middlecourseproject/data/repository/AuthRepositoryImpl;", "bindCheckoutRepository", "Lcom/example/middlecourseproject/domain/checkout/repository/CheckoutRepository;", "checkoutRepositoryImpl", "Lcom/example/middlecourseproject/data/checkout/repository/CheckoutRepositoryImpl;", "bindLanguageRepositoryImpl", "Lcom/example/middlecourseproject/domain/repository/LanguageRepository;", "languageRepositoryImpl", "Lcom/example/middlecourseproject/data/repository/LanguageRepositoryImpl;", "bindStringProvider", "Lcom/example/middlecourseproject/presentation/utils/StringProvider;", "defaultStringProvider", "Lcom/example/middlecourseproject/presentation/utils/StringProviderImpl;", "bindTokenRepository", "Lcom/example/middlecourseproject/domain/repository/TokenRepository;", "tokenRepositoryImpl", "Lcom/example/middlecourseproject/data/repository/TokenRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.domain.repository.AuthRepository bindAuthRepository(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.repository.AuthRepositoryImpl authRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.domain.repository.TokenRepository bindTokenRepository(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.repository.TokenRepositoryImpl tokenRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.domain.repository.LanguageRepository bindLanguageRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.repository.LanguageRepositoryImpl languageRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.presentation.utils.StringProvider bindStringProvider(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.utils.StringProviderImpl defaultStringProvider);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository bindCheckoutRepository(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.checkout.repository.CheckoutRepositoryImpl checkoutRepositoryImpl);
}