package com.example.middlecourseproject.presentation.checkout.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/example/middlecourseproject/presentation/checkout/viewmodel/PaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "addPaymentMethodUseCase", "Lcom/example/middlecourseproject/domain/checkout/usecase/AddPaymentMethodUseCase;", "(Lcom/example/middlecourseproject/domain/checkout/usecase/AddPaymentMethodUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/checkout/viewmodel/PaymentState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "addCard", "", "cardNumber", "", "expiryDate", "cvv", "cardholderName", "detectCardType", "Lcom/example/middlecourseproject/domain/checkout/model/CardType;", "isValidLuhn", "", "parseExpiryDate", "Lkotlin/Pair;", "", "validateCardInput", "Lcom/example/middlecourseproject/presentation/checkout/viewmodel/PaymentViewModel$ValidationResult;", "ValidationResult", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PaymentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.checkout.usecase.AddPaymentMethodUseCase addPaymentMethodUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.checkout.viewmodel.PaymentState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.checkout.viewmodel.PaymentState> state = null;
    
    @javax.inject.Inject()
    public PaymentViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.usecase.AddPaymentMethodUseCase addPaymentMethodUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.checkout.viewmodel.PaymentState> getState() {
        return null;
    }
    
    public final void addCard(@org.jetbrains.annotations.NotNull()
    java.lang.String cardNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String expiryDate, @org.jetbrains.annotations.NotNull()
    java.lang.String cvv, @org.jetbrains.annotations.NotNull()
    java.lang.String cardholderName) {
    }
    
    private final com.example.middlecourseproject.presentation.checkout.viewmodel.PaymentViewModel.ValidationResult validateCardInput(java.lang.String cardNumber, java.lang.String expiryDate, java.lang.String cvv, java.lang.String cardholderName) {
        return null;
    }
    
    private final kotlin.Pair<java.lang.Integer, java.lang.Integer> parseExpiryDate(java.lang.String expiryDate) {
        return null;
    }
    
    private final com.example.middlecourseproject.domain.checkout.model.CardType detectCardType(java.lang.String cardNumber) {
        return null;
    }
    
    private final boolean isValidLuhn(java.lang.String cardNumber) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/example/middlecourseproject/presentation/checkout/viewmodel/PaymentViewModel$ValidationResult;", "", "cardNumberError", "", "expiryDateError", "cvvError", "cardholderNameError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardNumberError", "()Ljava/lang/String;", "setCardNumberError", "(Ljava/lang/String;)V", "getCardholderNameError", "setCardholderNameError", "getCvvError", "setCvvError", "getExpiryDateError", "setExpiryDateError", "isValid", "", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ValidationResult {
        @org.jetbrains.annotations.Nullable()
        private java.lang.String cardNumberError;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String expiryDateError;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String cvvError;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String cardholderNameError;
        
        public ValidationResult(@org.jetbrains.annotations.Nullable()
        java.lang.String cardNumberError, @org.jetbrains.annotations.Nullable()
        java.lang.String expiryDateError, @org.jetbrains.annotations.Nullable()
        java.lang.String cvvError, @org.jetbrains.annotations.Nullable()
        java.lang.String cardholderNameError) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCardNumberError() {
            return null;
        }
        
        public final void setCardNumberError(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getExpiryDateError() {
            return null;
        }
        
        public final void setExpiryDateError(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCvvError() {
            return null;
        }
        
        public final void setCvvError(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCardholderNameError() {
            return null;
        }
        
        public final void setCardholderNameError(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final boolean isValid() {
            return false;
        }
        
        public ValidationResult() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.middlecourseproject.presentation.checkout.viewmodel.PaymentViewModel.ValidationResult copy(@org.jetbrains.annotations.Nullable()
        java.lang.String cardNumberError, @org.jetbrains.annotations.Nullable()
        java.lang.String expiryDateError, @org.jetbrains.annotations.Nullable()
        java.lang.String cvvError, @org.jetbrains.annotations.Nullable()
        java.lang.String cardholderNameError) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}