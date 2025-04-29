package com.example.middlecourseproject.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/middlecourseproject/data/remote/FoodRemoteMediator;", "Landroidx/paging/RemoteMediator;", "", "Lcom/example/middlecourseproject/data/local/roomDB/entity/RecipeEntity;", "query", "", "foodService", "Lcom/example/middlecourseproject/data/remote/services/FoodService;", "appDatabase", "Lcom/example/middlecourseproject/data/local/roomDB/database/AppDatabase;", "networkUtil", "Lcom/example/middlecourseproject/utils/NetworkUtil;", "(Ljava/lang/String;Lcom/example/middlecourseproject/data/remote/services/FoodService;Lcom/example/middlecourseproject/data/local/roomDB/database/AppDatabase;Lcom/example/middlecourseproject/utils/NetworkUtil;)V", "load", "Landroidx/paging/RemoteMediator$MediatorResult;", "loadType", "Landroidx/paging/LoadType;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
public final class FoodRemoteMediator extends androidx.paging.RemoteMediator<java.lang.Integer, com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String query = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.remote.services.FoodService foodService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.local.roomDB.database.AppDatabase appDatabase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.utils.NetworkUtil networkUtil = null;
    
    public FoodRemoteMediator(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.remote.services.FoodService foodService, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.local.roomDB.database.AppDatabase appDatabase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.utils.NetworkUtil networkUtil) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object load(@org.jetbrains.annotations.NotNull()
    androidx.paging.LoadType loadType, @org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<java.lang.Integer, com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity> state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.MediatorResult> $completion) {
        return null;
    }
}