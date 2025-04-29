package com.example.middlecourseproject.presentation.auth.register;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/example/middlecourseproject/presentation/auth/register/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "registerUseCase", "Lcom/example/middlecourseproject/domain/useCases/RegisterUseCase;", "errorMapper", "Lcom/example/middlecourseproject/presentation/utils/ErrorMapper;", "(Lcom/example/middlecourseproject/domain/useCases/RegisterUseCase;Lcom/example/middlecourseproject/presentation/utils/ErrorMapper;)V", "_sideEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/middlecourseproject/presentation/auth/register/RegisterSideEffect;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/auth/register/RegisterState;", "sideEffect", "Lkotlinx/coroutines/flow/SharedFlow;", "getSideEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "handleRegister", "", "processIntent", "intent", "Lcom/example/middlecourseproject/presentation/auth/register/RegisterIntent;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RegisterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.useCases.RegisterUseCase registerUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.presentation.utils.ErrorMapper errorMapper = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.auth.register.RegisterState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.auth.register.RegisterState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.middlecourseproject.presentation.auth.register.RegisterSideEffect> _sideEffect = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.example.middlecourseproject.presentation.auth.register.RegisterSideEffect> sideEffect = null;
    
    @javax.inject.Inject()
    public RegisterViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.useCases.RegisterUseCase registerUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.utils.ErrorMapper errorMapper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.auth.register.RegisterState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.example.middlecourseproject.presentation.auth.register.RegisterSideEffect> getSideEffect() {
        return null;
    }
    
    public final void processIntent(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.auth.register.RegisterIntent intent) {
    }
    
    private final void handleRegister() {
    }
}