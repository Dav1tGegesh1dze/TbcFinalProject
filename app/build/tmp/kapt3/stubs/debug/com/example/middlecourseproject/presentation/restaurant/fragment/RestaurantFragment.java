package com.example.middlecourseproject.presentation.restaurant.fragment;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0003J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020#H\u0002J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u001a\u00100\u001a\u00020#2\u0006\u00101\u001a\u0002022\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0016J\b\u0010;\u001a\u00020#H\u0002J\"\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u000f0\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006A"}, d2 = {"Lcom/example/middlecourseproject/presentation/restaurant/fragment/RestaurantFragment;", "Lcom/example/middlecourseproject/presentation/base/BaseFragment;", "Lcom/example/middlecourseproject/databinding/FragmentRestaurantBinding;", "()V", "adBannerAdapter", "Lcom/example/middlecourseproject/presentation/restaurant/adapter/AdBannerAdapter;", "categoryAdapter", "Lcom/example/middlecourseproject/presentation/restaurant/adapter/CategoryAdapter;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "handler", "Landroid/os/Handler;", "locationPermissionRequest", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "notificationPermissionLauncher", "kotlin.jvm.PlatformType", "orderManager", "Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "getOrderManager", "()Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "setOrderManager", "(Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;)V", "restaurantAdapter", "Lcom/example/middlecourseproject/presentation/restaurant/adapter/RestaurantAdapter;", "updateOrderTimeRunnable", "Ljava/lang/Runnable;", "viewModel", "Lcom/example/middlecourseproject/presentation/restaurant/viewmodel/RestaurantViewModel;", "getViewModel", "()Lcom/example/middlecourseproject/presentation/restaurant/viewmodel/RestaurantViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkNotificationPermission", "", "getLocationAndUpdate", "handleAdBannerClick", "adBanner", "Lcom/example/middlecourseproject/domain/restaurant/model/AdBanner;", "hasLocationPermission", "", "observeState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "requestLocationPermission", "setupActiveOrderButton", "setupLocationBar", "setupRecyclerViews", "showLocationBottomSheet", "showLocationPermissionRationale", "showNotificationPermissionRationale", "start", "updateActiveOrderButton", "updateLocationDisplay", "latitude", "", "longitude", "address", "app_debug"})
public final class RestaurantFragment extends com.example.middlecourseproject.presentation.base.BaseFragment<com.example.middlecourseproject.databinding.FragmentRestaurantBinding> {
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.checkout.manager.OrderManager orderManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.presentation.restaurant.adapter.CategoryAdapter categoryAdapter = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.presentation.restaurant.adapter.AdBannerAdapter adBannerAdapter = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.presentation.restaurant.adapter.RestaurantAdapter restaurantAdapter = null;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable updateOrderTimeRunnable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> locationPermissionRequest = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> notificationPermissionLauncher = null;
    
    public RestaurantFragment() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.manager.OrderManager getOrderManager() {
        return null;
    }
    
    public final void setOrderManager(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.manager.OrderManager p0) {
    }
    
    private final com.example.middlecourseproject.presentation.restaurant.viewmodel.RestaurantViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void start() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void setupRecyclerViews() {
    }
    
    private final void setupLocationBar() {
    }
    
    private final void setupActiveOrderButton() {
    }
    
    private final void updateActiveOrderButton() {
    }
    
    private final void handleAdBannerClick(com.example.middlecourseproject.domain.restaurant.model.AdBanner adBanner) {
    }
    
    private final void showLocationBottomSheet() {
    }
    
    private final void updateLocationDisplay(double latitude, double longitude, java.lang.String address) {
    }
    
    private final boolean hasLocationPermission() {
        return false;
    }
    
    private final void requestLocationPermission() {
    }
    
    private final void showLocationPermissionRationale() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getLocationAndUpdate() {
    }
    
    private final void checkNotificationPermission() {
    }
    
    private final void showNotificationPermissionRationale() {
    }
    
    private final void observeState() {
    }
}