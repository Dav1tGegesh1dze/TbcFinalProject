package com.example.middlecourseproject.data.local.roomDB.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/middlecourseproject/data/local/roomDB/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cartDao", "Lcom/example/middlecourseproject/data/cart/local/dao/CartDao;", "foodDao", "Lcom/example/middlecourseproject/data/local/roomDB/dao/FoodDao;", "app_debug"})
@androidx.room.Database(entities = {com.example.middlecourseproject.data.local.roomDB.entity.RecipeEntity.class, com.example.middlecourseproject.data.cart.local.entity.CartItemEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.data.local.roomDB.dao.FoodDao foodDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.middlecourseproject.data.cart.local.dao.CartDao cartDao();
}