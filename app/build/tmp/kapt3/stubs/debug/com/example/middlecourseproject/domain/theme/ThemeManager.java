package com.example.middlecourseproject.domain.theme;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/middlecourseproject/domain/theme/ThemeManager;", "", "preferencesHelper", "Lcom/example/middlecourseproject/data/local/sharedPreferences/PreferencesHelper;", "(Lcom/example/middlecourseproject/data/local/sharedPreferences/PreferencesHelper;)V", "_isDarkMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isDarkMode", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "applyTheme", "", "isDarkModeActive", "toggleTheme", "Companion", "app_debug"})
public final class ThemeManager {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper preferencesHelper = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String THEME_KEY = "app_theme";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isDarkMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkMode = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.domain.theme.ThemeManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public ThemeManager(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.local.sharedPreferences.PreferencesHelper preferencesHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDarkMode() {
        return null;
    }
    
    public final boolean isDarkModeActive() {
        return false;
    }
    
    public final boolean toggleTheme() {
        return false;
    }
    
    public final void applyTheme() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/middlecourseproject/domain/theme/ThemeManager$Companion;", "", "()V", "THEME_KEY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}