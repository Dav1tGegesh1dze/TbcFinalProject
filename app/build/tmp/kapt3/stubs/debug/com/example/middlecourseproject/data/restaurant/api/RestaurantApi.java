package com.example.middlecourseproject.data.restaurant.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/example/middlecourseproject/data/restaurant/api/RestaurantApi;", "", "getAdBanners", "Lcom/example/middlecourseproject/data/restaurant/model/AdBannersResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRestaurants", "", "Lcom/example/middlecourseproject/data/restaurant/model/RestaurantDto;", "app_debug"})
public abstract interface RestaurantApi {
    
    @retrofit2.http.GET(value = "9a30c502-f0a1-4677-8750-fa2bd40a1562")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRestaurants(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.middlecourseproject.data.restaurant.model.RestaurantDto>> $completion);
    
    @retrofit2.http.GET(value = "7e60c5e9-8e98-428d-a418-54d0e424b9fe")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAdBanners(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.middlecourseproject.data.restaurant.model.AdBannersResponse> $completion);
}