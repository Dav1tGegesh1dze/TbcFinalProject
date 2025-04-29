package com.example.middlecourseproject.data.cart.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\rH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0016J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0019J\f\u0010\u001a\u001a\u00020\b*\u00020\u001bH\u0002J\f\u0010\u001c\u001a\u00020\u001b*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/middlecourseproject/data/cart/repository/CartRepositoryImpl;", "Lcom/example/middlecourseproject/domain/cart/repository/CartRepository;", "cartDao", "Lcom/example/middlecourseproject/data/cart/local/dao/CartDao;", "(Lcom/example/middlecourseproject/data/cart/local/dao/CartDao;)V", "addItemToCart", "", "item", "Lcom/example/middlecourseproject/domain/cart/CartItem;", "(Lcom/example/middlecourseproject/domain/cart/CartItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCartItemCount", "Lkotlinx/coroutines/flow/Flow;", "", "getCartItems", "", "getCartTotal", "", "removeItemFromCart", "dishId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateItemQuantity", "quantity", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomainModel", "Lcom/example/middlecourseproject/data/cart/local/entity/CartItemEntity;", "toEntity", "app_debug"})
public final class CartRepositoryImpl implements com.example.middlecourseproject.domain.cart.repository.CartRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.cart.local.dao.CartDao cartDao = null;
    
    @javax.inject.Inject()
    public CartRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.cart.local.dao.CartDao cartDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.domain.cart.CartItem>> getCartItems() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addItemToCart(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.cart.CartItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateItemQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId, int quantity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object removeItemFromCart(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearCart(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Double> getCartTotal() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Integer> getCartItemCount() {
        return null;
    }
    
    private final com.example.middlecourseproject.domain.cart.CartItem toDomainModel(com.example.middlecourseproject.data.cart.local.entity.CartItemEntity $this$toDomainModel) {
        return null;
    }
    
    private final com.example.middlecourseproject.data.cart.local.entity.CartItemEntity toEntity(com.example.middlecourseproject.domain.cart.CartItem $this$toEntity) {
        return null;
    }
}