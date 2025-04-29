package com.example.middlecourseproject.domain.checkout.notification;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0013H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/notification/MyFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "notificationService", "Lcom/example/middlecourseproject/domain/checkout/notification/NotificationService;", "getNotificationService", "()Lcom/example/middlecourseproject/domain/checkout/notification/NotificationService;", "setNotificationService", "(Lcom/example/middlecourseproject/domain/checkout/notification/NotificationService;)V", "orderManager", "Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "getOrderManager", "()Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "setOrderManager", "(Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;)V", "handleOrderStatusUpdate", "", "data", "", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "Companion", "app_debug"})
public final class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.checkout.notification.NotificationService notificationService;
    @javax.inject.Inject()
    public com.example.middlecourseproject.domain.checkout.manager.OrderManager orderManager;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FCM_Service";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.domain.checkout.notification.MyFirebaseMessagingService.Companion Companion = null;
    
    public MyFirebaseMessagingService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.notification.NotificationService getNotificationService() {
        return null;
    }
    
    public final void setNotificationService(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.notification.NotificationService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.manager.OrderManager getOrderManager() {
        return null;
    }
    
    public final void setOrderManager(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.manager.OrderManager p0) {
    }
    
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    private final void handleOrderStatusUpdate(java.util.Map<java.lang.String, java.lang.String> data) {
    }
    
    @java.lang.Override()
    public void onNewToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/notification/MyFirebaseMessagingService$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}