package com.example.middlecourseproject;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/middlecourseproject/MyApplication;", "Landroid/app/Application;", "()V", "themeManager", "Lcom/example/middlecourseproject/domain/theme/ThemeManager;", "getThemeManager", "()Lcom/example/middlecourseproject/domain/theme/ThemeManager;", "setThemeManager", "(Lcom/example/middlecourseproject/domain/theme/ThemeManager;)V", "onCreate", "", "app_debug"})
public final class MyApplication extends android.app.Application {
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.theme.ThemeManager themeManager;
    
    public MyApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.theme.ThemeManager getThemeManager() {
        return null;
    }
    
    public final void setThemeManager(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.theme.ThemeManager p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
}