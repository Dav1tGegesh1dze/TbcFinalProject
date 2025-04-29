package com.example.middlecourseproject.presentation.base;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/example/middlecourseproject/presentation/base/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/middlecourseproject/databinding/ActivityMainBinding;", "checkAuthTokenUseCase", "Lcom/example/middlecourseproject/domain/useCases/CheckAuthTokenUseCase;", "getCheckAuthTokenUseCase", "()Lcom/example/middlecourseproject/domain/useCases/CheckAuthTokenUseCase;", "setCheckAuthTokenUseCase", "(Lcom/example/middlecourseproject/domain/useCases/CheckAuthTokenUseCase;)V", "isNavigationReady", "", "themeManager", "Lcom/example/middlecourseproject/domain/theme/ThemeManager;", "getThemeManager", "()Lcom/example/middlecourseproject/domain/theme/ThemeManager;", "setThemeManager", "(Lcom/example/middlecourseproject/domain/theme/ThemeManager;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "observeThemeChanges", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpNavigation", "updateBottomNavigationTheme", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.middlecourseproject.databinding.ActivityMainBinding binding;
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.useCases.CheckAuthTokenUseCase checkAuthTokenUseCase;
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.theme.ThemeManager themeManager;
    @kotlin.jvm.Volatile()
    private volatile boolean isNavigationReady = false;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.useCases.CheckAuthTokenUseCase getCheckAuthTokenUseCase() {
        return null;
    }
    
    public final void setCheckAuthTokenUseCase(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.CheckAuthTokenUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.theme.ThemeManager getThemeManager() {
        return null;
    }
    
    public final void setThemeManager(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.theme.ThemeManager p0) {
    }
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull()
    android.content.Context newBase) {
    }
    
    @java.lang.Override()
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeThemeChanges() {
    }
    
    private final void updateBottomNavigationTheme() {
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    private final void setUpNavigation() {
    }
}