package com.example.middlecourseproject.domain.checkout.notification;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\"\u0010\u0019\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/notification/OrderTrackingService;", "Landroid/app/Service;", "()V", "handler", "Landroid/os/Handler;", "lastStatusValue", "", "orderManager", "Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "getOrderManager", "()Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "setOrderManager", "(Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;)V", "updateIntervalMillis", "", "createForegroundNotification", "Landroid/app/Notification;", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "sendStatusNotification", "title", "", "message", "startOrderTracking", "Companion", "app_debug"})
public final class OrderTrackingService extends android.app.Service {
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.checkout.manager.OrderManager orderManager;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private final long updateIntervalMillis = 10000L;
    private int lastStatusValue = -1;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "OrderTrackingService";
    public static final int FOREGROUND_NOTIFICATION_ID = 1001;
    public static final int STATUS_NOTIFICATION_ID = 1002;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "order_status_channel";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.domain.checkout.notification.OrderTrackingService.Companion Companion = null;
    
    public OrderTrackingService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.manager.OrderManager getOrderManager() {
        return null;
    }
    
    public final void setOrderManager(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.manager.OrderManager p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void startOrderTracking() {
    }
    
    private final android.app.Notification createForegroundNotification() {
        return null;
    }
    
    private final void sendStatusNotification(java.lang.String title, java.lang.String message) {
    }
    
    private final void createNotificationChannel() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/notification/OrderTrackingService$Companion;", "", "()V", "CHANNEL_ID", "", "FOREGROUND_NOTIFICATION_ID", "", "STATUS_NOTIFICATION_ID", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}