package com.example.middlecourseproject.data.remote.services;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/middlecourseproject/data/remote/services/AuthService;", "", "login", "Lretrofit2/Response;", "Lcom/example/middlecourseproject/data/remote/dtos/LoginDto;", "request", "Lcom/example/middlecourseproject/data/remote/dtos/LoginRequest;", "(Lcom/example/middlecourseproject/data/remote/dtos/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "otpValidation", "Lcom/example/middlecourseproject/data/remote/dtos/OtpDto;", "Lcom/example/middlecourseproject/data/remote/dtos/OtpRequest;", "(Lcom/example/middlecourseproject/data/remote/dtos/OtpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/example/middlecourseproject/data/remote/dtos/RegisterDto;", "Lcom/example/middlecourseproject/data/remote/dtos/RegisterRequest;", "(Lcom/example/middlecourseproject/data/remote/dtos/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthService {
    
    @retrofit2.http.POST(value = "/UserOnboarding/register-user/manual")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.remote.dtos.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.middlecourseproject.data.remote.dtos.RegisterDto>> $completion);
    
    @retrofit2.http.POST(value = "/Auth/manual")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.remote.dtos.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.middlecourseproject.data.remote.dtos.LoginDto>> $completion);
    
    @retrofit2.http.POST(value = "/UserOnboarding/register-user/manual/otp-verification")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object otpValidation(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.remote.dtos.OtpRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.middlecourseproject.data.remote.dtos.OtpDto>> $completion);
}