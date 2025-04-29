package com.example.middlecourseproject.presentation.checkout.fragment;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00102\u001a\u000203H\u0007J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000203H\u0002J$\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u000203H\u0016J\b\u0010@\u001a\u000203H\u0017J\b\u0010A\u001a\u000203H\u0016J\u001a\u0010B\u001a\u0002032\u0006\u0010C\u001a\u0002082\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010D\u001a\u000203H\u0002J\b\u0010E\u001a\u000203H\u0002J\b\u0010F\u001a\u000203H\u0002J\u0018\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\u0016H\u0002J\u0010\u0010K\u001a\u0002032\u0006\u0010L\u001a\u00020\u0006H\u0002J.\u0010M\u001a\u000203*\u00020N2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020RH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010TR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\r\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR+\u0010(\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R+\u0010,\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R\u000e\u00100\u001a\u000201X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006U"}, d2 = {"Lcom/example/middlecourseproject/presentation/checkout/fragment/OrderConfirmationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "countDownTimer", "Landroid/os/CountDownTimer;", "<set-?>", "", "currentStage", "getCurrentStage", "()I", "setCurrentStage", "(I)V", "currentStage$delegate", "Landroidx/compose/runtime/MutableState;", "", "deliveryAddress", "getDeliveryAddress", "()Ljava/lang/String;", "setDeliveryAddress", "(Ljava/lang/String;)V", "deliveryAddress$delegate", "deliveryTimeMillis", "", "estimatedDeliveryTime", "getEstimatedDeliveryTime", "setEstimatedDeliveryTime", "estimatedDeliveryTime$delegate", "isNewOrder", "", "lastOrderStatus", "orderManager", "Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "getOrderManager", "()Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "setOrderManager", "(Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;)V", "orderProgress", "getOrderProgress", "setOrderProgress", "orderProgress$delegate", "orderTrackingMessage", "getOrderTrackingMessage", "setOrderTrackingMessage", "orderTrackingMessage$delegate", "remainingTime", "getRemainingTime", "setRemainingTime", "remainingTime$delegate", "statusUpdateReceiver", "Landroid/content/BroadcastReceiver;", "OrderConfirmationScreen", "", "checkExistingOrder", "continueShoppingClicked", "loadExistingOrder", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onStart", "onStop", "onViewCreated", "view", "resetOrderStatusIndicators", "setupDeliveryTime", "startOrderTracking", "updateOrderStatus", "totalTime", "updateRemainingTime", "millisUntilFinished", "updateUIForStatus", "statusValue", "OrderStageText", "Landroidx/compose/foundation/layout/RowScope;", "text", "isActive", "accentColor", "Landroidx/compose/ui/graphics/Color;", "OrderStageText-g2O1Hgs", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;ZJ)V", "app_debug"})
public final class OrderConfirmationFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.checkout.manager.OrderManager orderManager;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer countDownTimer;
    private long deliveryTimeMillis = 0L;
    private boolean isNewOrder = false;
    private int lastOrderStatus = -1;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState estimatedDeliveryTime$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState remainingTime$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState orderTrackingMessage$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState orderProgress$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState deliveryAddress$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState currentStage$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.BroadcastReceiver statusUpdateReceiver = null;
    
    public OrderConfirmationFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.manager.OrderManager getOrderManager() {
        return null;
    }
    
    public final void setOrderManager(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.manager.OrderManager p0) {
    }
    
    private final java.lang.String getEstimatedDeliveryTime() {
        return null;
    }
    
    private final void setEstimatedDeliveryTime(java.lang.String p0) {
    }
    
    private final java.lang.String getRemainingTime() {
        return null;
    }
    
    private final void setRemainingTime(java.lang.String p0) {
    }
    
    private final java.lang.String getOrderTrackingMessage() {
        return null;
    }
    
    private final void setOrderTrackingMessage(java.lang.String p0) {
    }
    
    private final int getOrderProgress() {
        return 0;
    }
    
    private final void setOrderProgress(int p0) {
    }
    
    private final java.lang.String getDeliveryAddress() {
        return null;
    }
    
    private final void setDeliveryAddress(java.lang.String p0) {
    }
    
    private final int getCurrentStage() {
        return 0;
    }
    
    private final void setCurrentStage(int p0) {
    }
    
    @java.lang.Override()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void continueShoppingClicked() {
    }
    
    private final void checkExistingOrder() {
    }
    
    private final void loadExistingOrder() {
    }
    
    private final void setupDeliveryTime() {
    }
    
    private final void startOrderTracking() {
    }
    
    private final void updateRemainingTime(long millisUntilFinished) {
    }
    
    private final void updateOrderStatus(long totalTime, long remainingTime) {
    }
    
    private final void updateUIForStatus(int statusValue) {
    }
    
    private final void resetOrderStatusIndicators() {
    }
    
    @androidx.compose.runtime.Composable()
    public final void OrderConfirmationScreen() {
    }
}