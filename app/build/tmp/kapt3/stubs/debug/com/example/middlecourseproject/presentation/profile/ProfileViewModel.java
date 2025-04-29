package com.example.middlecourseproject.presentation.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/middlecourseproject/presentation/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "signOutUseCase", "Lcom/example/middlecourseproject/domain/useCases/SignOutUseCase;", "toggleLanguageUseCase", "Lcom/example/middlecourseproject/domain/useCases/ToggleLanguageUseCase;", "getLanguageUseCase", "Lcom/example/middlecourseproject/domain/useCases/GetLanguageUseCase;", "themeToggleUseCase", "Lcom/example/middlecourseproject/domain/useCases/ThemeToggleUseCase;", "getThemeUseCase", "Lcom/example/middlecourseproject/domain/useCases/GetThemeUseCase;", "(Lcom/example/middlecourseproject/domain/useCases/SignOutUseCase;Lcom/example/middlecourseproject/domain/useCases/ToggleLanguageUseCase;Lcom/example/middlecourseproject/domain/useCases/GetLanguageUseCase;Lcom/example/middlecourseproject/domain/useCases/ThemeToggleUseCase;Lcom/example/middlecourseproject/domain/useCases/GetThemeUseCase;)V", "_sideEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/middlecourseproject/presentation/profile/ProfileSideEffect;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/profile/ProfileState;", "sideEffect", "Lkotlinx/coroutines/flow/SharedFlow;", "getSideEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "handleSignOut", "", "loadInitialState", "processIntent", "intent", "Lcom/example/middlecourseproject/presentation/profile/ProfileIntent;", "toggleLanguage", "toggleTheme", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.SignOutUseCase signOutUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase toggleLanguageUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.GetLanguageUseCase getLanguageUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.ThemeToggleUseCase themeToggleUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.GetThemeUseCase getThemeUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.profile.ProfileState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.profile.ProfileState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.middlecourseproject.presentation.profile.ProfileSideEffect> _sideEffect = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.example.middlecourseproject.presentation.profile.ProfileSideEffect> sideEffect = null;
    
    @javax.inject.Inject()
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.SignOutUseCase signOutUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase toggleLanguageUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.GetLanguageUseCase getLanguageUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.ThemeToggleUseCase themeToggleUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.GetThemeUseCase getThemeUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.profile.ProfileState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.example.middlecourseproject.presentation.profile.ProfileSideEffect> getSideEffect() {
        return null;
    }
    
    private final void loadInitialState() {
    }
    
    public final void processIntent(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.profile.ProfileIntent intent) {
    }
    
    private final void handleSignOut() {
    }
    
    private final void toggleTheme() {
    }
    
    private final void toggleLanguage() {
    }
}