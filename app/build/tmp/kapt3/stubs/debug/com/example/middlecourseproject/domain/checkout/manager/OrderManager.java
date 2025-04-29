package com.example.middlecourseproject.domain.checkout.manager;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000  2\u00020\u0001:\u0002 !B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\r\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager;", "", "context", "Landroid/content/Context;", "notificationService", "Lcom/example/middlecourseproject/domain/checkout/notification/NotificationService;", "(Landroid/content/Context;Lcom/example/middlecourseproject/domain/checkout/notification/NotificationService;)V", "prefs", "Landroid/content/SharedPreferences;", "completeOrder", "", "createOrder", "deliveryTimeMinutes", "", "deliveryAddress", "", "getCurrentOrderStatus", "Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager$OrderStatus;", "getDeliveryAddress", "getDeliveryTimeMillis", "", "getOrderPlacedTimeMillis", "getRemainingTimeMillis", "()Ljava/lang/Long;", "getStatusForProgress", "progressPercentage", "hasActiveOrder", "", "sendNotification", "status", "startOrderTrackingService", "updateOrderStatus", "Companion", "OrderStatus", "app_debug"})
public final class OrderManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.checkout.notification.NotificationService notificationService = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "order_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ACTIVE_ORDER = "active_order";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DELIVERY_TIME = "delivery_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ORDER_PLACED_TIME = "order_placed_time";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DELIVERY_ADDRESS = "delivery_address";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ORDER_STATUS = "order_status";
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.domain.checkout.manager.OrderManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public OrderManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.notification.NotificationService notificationService) {
        super();
    }
    
    public final void createOrder(int deliveryTimeMinutes, @org.jetbrains.annotations.NotNull()
    java.lang.String deliveryAddress) {
    }
    
    private final void startOrderTrackingService() {
    }
    
    public final boolean hasActiveOrder() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getRemainingTimeMillis() {
        return null;
    }
    
    public final long getDeliveryTimeMillis() {
        return 0L;
    }
    
    public final long getOrderPlacedTimeMillis() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeliveryAddress() {
        return null;
    }
    
    public final void updateOrderStatus(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.manager.OrderManager.OrderStatus status) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.manager.OrderManager.OrderStatus getCurrentOrderStatus() {
        return null;
    }
    
    private final void sendNotification(com.example.middlecourseproject.domain.checkout.manager.OrderManager.OrderStatus status) {
    }
    
    public final void completeOrder() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.manager.OrderManager.OrderStatus getStatusForProgress(int progressPercentage) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager$Companion;", "", "()V", "KEY_ACTIVE_ORDER", "", "KEY_DELIVERY_ADDRESS", "KEY_DELIVERY_TIME", "KEY_ORDER_PLACED_TIME", "KEY_ORDER_STATUS", "PREFS_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/example/middlecourseproject/domain/checkout/manager/OrderManager$OrderStatus;", "", "value", "", "title", "", "message", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getTitle", "getValue", "()I", "CONFIRMED", "PREPARING", "ON_THE_WAY", "ARRIVING", "DELIVERED", "app_debug"})
    public static enum OrderStatus {
        /*public static final*/ CONFIRMED /* = new CONFIRMED(0, null, null) */,
        /*public static final*/ PREPARING /* = new PREPARING(0, null, null) */,
        /*public static final*/ ON_THE_WAY /* = new ON_THE_WAY(0, null, null) */,
        /*public static final*/ ARRIVING /* = new ARRIVING(0, null, null) */,
        /*public static final*/ DELIVERED /* = new DELIVERED(0, null, null) */;
        private final int value = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        OrderStatus(int value, java.lang.String title, java.lang.String message) {
        }
        
        public final int getValue() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.example.middlecourseproject.domain.checkout.manager.OrderManager.OrderStatus> getEntries() {
            return null;
        }
    }
}