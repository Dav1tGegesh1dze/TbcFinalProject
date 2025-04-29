package com.example.middlecourseproject.data.cart.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\'J\u0018\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/example/middlecourseproject/data/cart/local/dao/CartDao;", "", "clearCart", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCartItem", "dishId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCartItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/middlecourseproject/data/cart/local/entity/CartItemEntity;", "getCartItemById", "insertCartItem", "cartItem", "(Lcom/example/middlecourseproject/data/cart/local/entity/CartItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateItemQuantity", "quantity", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface CartDao {
    
    @androidx.room.Query(value = "SELECT * FROM cart_items")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.middlecourseproject.data.cart.local.entity.CartItemEntity>> getAllCartItems();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCartItem(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.cart.local.entity.CartItemEntity cartItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM cart_items WHERE dishId = :dishId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteCartItem(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM cart_items")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearCart(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE cart_items SET quantity = :quantity WHERE dishId = :dishId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateItemQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId, int quantity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM cart_items WHERE dishId = :dishId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCartItemById(@org.jetbrains.annotations.NotNull()
    java.lang.String dishId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.middlecourseproject.data.cart.local.entity.CartItemEntity> $completion);
}