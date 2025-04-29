package com.example.middlecourseproject.di;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/middlecourseproject/di/LocaleHelperEntryPoint;", "", "localeHelper", "Lcom/example/middlecourseproject/data/local/sharedPreferences/LocaleHelper;", "preferencesHelper", "Lcom/example/middlecourseproject/data/local/sharedPreferences/PreferencesHelper;", "app_debug"})
@dagger.hilt.EntryPoint()
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract interface LocaleHelperEntryPoint {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper preferencesHelper();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.data.local.sharedPreferences.LocaleHelper localeHelper();
}