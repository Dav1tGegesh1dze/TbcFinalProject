package com.example.middlecourseproject.presentation.dish.fragment;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/example/middlecourseproject/presentation/dish/fragment/DishesFragment;", "Lcom/example/middlecourseproject/presentation/base/BaseFragment;", "Lcom/example/middlecourseproject/databinding/FragmentDishesBinding;", "Landroidx/core/view/MenuProvider;", "()V", "args", "Lcom/example/middlecourseproject/presentation/dish/fragment/DishesFragmentArgs;", "getArgs", "()Lcom/example/middlecourseproject/presentation/dish/fragment/DishesFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "cartMenuItem", "Landroid/view/MenuItem;", "dishAdapter", "Lcom/example/middlecourseproject/presentation/dish/adapter/DishAdapter;", "viewModel", "Lcom/example/middlecourseproject/presentation/dish/viewmodel/DishesViewModel;", "getViewModel", "()Lcom/example/middlecourseproject/presentation/dish/viewmodel/DishesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeState", "", "onCreateMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onMenuItemSelected", "", "menuItem", "setupBackButton", "setupMenu", "setupRecyclerView", "start", "updateCartBadge", "count", "", "app_debug"})
public final class DishesFragment extends com.example.middlecourseproject.presentation.base.BaseFragment<com.example.middlecourseproject.databinding.FragmentDishesBinding> implements androidx.core.view.MenuProvider {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private com.example.middlecourseproject.presentation.dish.adapter.DishAdapter dishAdapter;
    @org.jetbrains.annotations.Nullable()
    private android.view.MenuItem cartMenuItem;
    
    public DishesFragment() {
        super(null);
    }
    
    private final com.example.middlecourseproject.presentation.dish.viewmodel.DishesViewModel getViewModel() {
        return null;
    }
    
    private final com.example.middlecourseproject.presentation.dish.fragment.DishesFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override()
    public void start() {
    }
    
    private final void setupBackButton() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupMenu() {
    }
    
    private final void observeState() {
    }
    
    private final void updateCartBadge(int count) {
    }
    
    @java.lang.Override()
    public void onCreateMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater menuInflater) {
    }
    
    @java.lang.Override()
    public boolean onMenuItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem menuItem) {
        return false;
    }
}