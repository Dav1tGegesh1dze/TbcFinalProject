package com.example.middlecourseproject.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/example/middlecourseproject/di/DatabaseModule;", "", "()V", "provideAppDatabase", "Lcom/example/middlecourseproject/data/local/roomDB/database/AppDatabase;", "context", "Landroid/content/Context;", "provideCartDao", "Lcom/example/middlecourseproject/data/cart/local/dao/CartDao;", "appDatabase", "provideErrorMapper", "Lcom/example/middlecourseproject/presentation/utils/ErrorMapper;", "stringProvider", "Lcom/example/middlecourseproject/presentation/utils/StringProvider;", "provideFoodDao", "Lcom/example/middlecourseproject/data/local/roomDB/dao/FoodDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.local.roomDB.database.AppDatabase provideAppDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.local.roomDB.dao.FoodDao provideFoodDao(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.local.roomDB.database.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.cart.local.dao.CartDao provideCartDao(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.local.roomDB.database.AppDatabase appDatabase) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.presentation.utils.ErrorMapper provideErrorMapper(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.utils.StringProvider stringProvider) {
        return null;
    }
}