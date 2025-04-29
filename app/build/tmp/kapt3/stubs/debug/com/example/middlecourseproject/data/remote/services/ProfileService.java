package com.example.middlecourseproject.data.remote.services;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/middlecourseproject/data/remote/services/ProfileService;", "", "getProfile", "Lretrofit2/Response;", "Lcom/example/middlecourseproject/data/remote/dtos/ProfileDto;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDetails", "Lcom/example/middlecourseproject/data/remote/dtos/DetailsDto;", "request", "Lcom/example/middlecourseproject/data/remote/dtos/DetailsRequest;", "(Ljava/lang/String;Lcom/example/middlecourseproject/data/remote/dtos/DetailsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ProfileService {
    
    @retrofit2.http.POST(value = "/UserProfile/create-or-update")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDetails(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.remote.dtos.DetailsRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.middlecourseproject.data.remote.dtos.DetailsDto>> $completion);
    
    @retrofit2.http.GET(value = "/UserProfile")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProfile(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.middlecourseproject.data.remote.dtos.ProfileDto>> $completion);
}