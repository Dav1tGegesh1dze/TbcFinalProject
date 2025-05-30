package com.example.middlecourseproject.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/middlecourseproject/domain/repository/UserProfileRepository;", "", "updateDetails", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/middlecourseproject/domain/utils/Resource;", "Lcom/example/middlecourseproject/domain/models/DetailsDomain;", "request", "Lcom/example/middlecourseproject/data/remote/dtos/DetailsRequest;", "(Lcom/example/middlecourseproject/data/remote/dtos/DetailsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface UserProfileRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDetails(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.remote.dtos.DetailsRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.middlecourseproject.domain.utils.Resource<com.example.middlecourseproject.domain.models.DetailsDomain>>> $completion);
}