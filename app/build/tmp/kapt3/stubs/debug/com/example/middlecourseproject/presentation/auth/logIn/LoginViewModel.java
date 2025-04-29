package com.example.middlecourseproject.presentation.auth.logIn;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001aH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/middlecourseproject/presentation/auth/logIn/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginUseCase", "Lcom/example/middlecourseproject/domain/useCases/LoginUseCase;", "toggleLanguageUseCase", "Lcom/example/middlecourseproject/domain/useCases/ToggleLanguageUseCase;", "getLanguageUseCase", "Lcom/example/middlecourseproject/domain/useCases/GetLanguageUseCase;", "errorMapper", "Lcom/example/middlecourseproject/presentation/utils/ErrorMapper;", "(Lcom/example/middlecourseproject/domain/useCases/LoginUseCase;Lcom/example/middlecourseproject/domain/useCases/ToggleLanguageUseCase;Lcom/example/middlecourseproject/domain/useCases/GetLanguageUseCase;Lcom/example/middlecourseproject/presentation/utils/ErrorMapper;)V", "_sideEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/middlecourseproject/presentation/auth/logIn/LoginSideEffect;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/auth/logIn/LoginState;", "sideEffect", "Lkotlinx/coroutines/flow/SharedFlow;", "getSideEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "handleLogin", "", "loadLanguage", "processIntent", "intent", "Lcom/example/middlecourseproject/presentation/auth/logIn/LoginIntent;", "toggleLanguage", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.LoginUseCase loginUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase toggleLanguageUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.GetLanguageUseCase getLanguageUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.presentation.utils.ErrorMapper errorMapper = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.auth.logIn.LoginState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.auth.logIn.LoginState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.middlecourseproject.presentation.auth.logIn.LoginSideEffect> _sideEffect = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.example.middlecourseproject.presentation.auth.logIn.LoginSideEffect> sideEffect = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.LoginUseCase loginUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.ToggleLanguageUseCase toggleLanguageUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.GetLanguageUseCase getLanguageUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.utils.ErrorMapper errorMapper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.auth.logIn.LoginState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.example.middlecourseproject.presentation.auth.logIn.LoginSideEffect> getSideEffect() {
        return null;
    }
    
    private final void loadLanguage() {
    }
    
    public final void processIntent(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.auth.logIn.LoginIntent intent) {
    }
    
    private final void handleLogin() {
    }
    
    private final void toggleLanguage() {
    }
}