package com.example.middlecourseproject.presentation.dish.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/middlecourseproject/presentation/dish/adapter/DishAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/middlecourseproject/domain/restaurant/model/Dish;", "Lcom/example/middlecourseproject/presentation/dish/adapter/DishAdapter$DishViewHolder;", "onAddToCartClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "restaurantCategoryId", "", "restaurantName", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setRestaurantInfo", "categoryId", "name", "DishDiffCallback", "DishViewHolder", "app_debug"})
public final class DishAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.middlecourseproject.domain.restaurant.model.Dish, com.example.middlecourseproject.presentation.dish.adapter.DishAdapter.DishViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.middlecourseproject.domain.restaurant.model.Dish, kotlin.Unit> onAddToCartClick = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String restaurantCategoryId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String restaurantName = "";
    
    public DishAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.middlecourseproject.domain.restaurant.model.Dish, kotlin.Unit> onAddToCartClick) {
        super(null);
    }
    
    public final void setRestaurantInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.middlecourseproject.presentation.dish.adapter.DishAdapter.DishViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.dish.adapter.DishAdapter.DishViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/middlecourseproject/presentation/dish/adapter/DishAdapter$DishDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/middlecourseproject/domain/restaurant/model/Dish;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DishDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.middlecourseproject.domain.restaurant.model.Dish> {
        
        public DishDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.middlecourseproject.domain.restaurant.model.Dish oldItem, @org.jetbrains.annotations.NotNull()
        com.example.middlecourseproject.domain.restaurant.model.Dish newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.middlecourseproject.domain.restaurant.model.Dish oldItem, @org.jetbrains.annotations.NotNull()
        com.example.middlecourseproject.domain.restaurant.model.Dish newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/middlecourseproject/presentation/dish/adapter/DishAdapter$DishViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/middlecourseproject/databinding/ItemDishBinding;", "(Lcom/example/middlecourseproject/presentation/dish/adapter/DishAdapter;Lcom/example/middlecourseproject/databinding/ItemDishBinding;)V", "bind", "", "dish", "Lcom/example/middlecourseproject/domain/restaurant/model/Dish;", "app_debug"})
    public final class DishViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.middlecourseproject.databinding.ItemDishBinding binding = null;
        
        public DishViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.middlecourseproject.databinding.ItemDishBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.middlecourseproject.domain.restaurant.model.Dish dish) {
        }
    }
}