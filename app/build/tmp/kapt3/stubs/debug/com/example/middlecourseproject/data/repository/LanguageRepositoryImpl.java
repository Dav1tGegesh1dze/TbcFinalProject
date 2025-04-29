package com.example.middlecourseproject.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/middlecourseproject/data/repository/LanguageRepositoryImpl;", "Lcom/example/middlecourseproject/domain/repository/LanguageRepository;", "preferencesHelper", "Lcom/example/middlecourseproject/data/local/sharedPreferences/PreferencesHelper;", "localeHelper", "Lcom/example/middlecourseproject/data/local/sharedPreferences/LocaleHelper;", "(Lcom/example/middlecourseproject/data/local/sharedPreferences/PreferencesHelper;Lcom/example/middlecourseproject/data/local/sharedPreferences/LocaleHelper;)V", "getLanguage", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLanguage", "", "language", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleLanguage", "app_debug"})
public final class LanguageRepositoryImpl implements com.example.middlecourseproject.domain.repository.LanguageRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper preferencesHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.local.sharedPreferences.LocaleHelper localeHelper = null;
    
    @javax.inject.Inject()
    public LanguageRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper preferencesHelper, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.local.sharedPreferences.LocaleHelper localeHelper) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLanguage(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object toggleLanguage(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}