package com.example.middlecourseproject.presentation.checkout.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u0010+\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010-\u001a\u00020\u0012H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\u009b\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u00c6\u0001J\u0013\u00107\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020:H\u00d6\u0001J\t\u0010;\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017\u00a8\u0006<"}, d2 = {"Lcom/example/middlecourseproject/presentation/checkout/viewmodel/CheckoutState;", "", "subtotal", "", "bagFee", "smallOrderFee", "serviceFee", "deliveryFee", "tip", "discount", "promoCode", "", "total", "deliveryAddress", "Lcom/example/middlecourseproject/domain/checkout/model/DeliveryAddress;", "paymentMethod", "Lcom/example/middlecourseproject/domain/checkout/model/PaymentMethod;", "isLoading", "", "error", "orderPlaced", "(DDDDDDDLjava/lang/String;DLcom/example/middlecourseproject/domain/checkout/model/DeliveryAddress;Lcom/example/middlecourseproject/domain/checkout/model/PaymentMethod;ZLjava/lang/String;Z)V", "getBagFee", "()D", "getDeliveryAddress", "()Lcom/example/middlecourseproject/domain/checkout/model/DeliveryAddress;", "getDeliveryFee", "getDiscount", "getError", "()Ljava/lang/String;", "()Z", "getOrderPlaced", "getPaymentMethod", "()Lcom/example/middlecourseproject/domain/checkout/model/PaymentMethod;", "getPromoCode", "getServiceFee", "getSmallOrderFee", "getSubtotal", "getTip", "getTotal", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class CheckoutState {
    private final double subtotal = 0.0;
    private final double bagFee = 0.0;
    private final double smallOrderFee = 0.0;
    private final double serviceFee = 0.0;
    private final double deliveryFee = 0.0;
    private final double tip = 0.0;
    private final double discount = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String promoCode = null;
    private final double total = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.checkout.model.DeliveryAddress deliveryAddress = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.middlecourseproject.domain.checkout.model.PaymentMethod paymentMethod = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    private final boolean orderPlaced = false;
    
    public CheckoutState(double subtotal, double bagFee, double smallOrderFee, double serviceFee, double deliveryFee, double tip, double discount, @org.jetbrains.annotations.Nullable()
    java.lang.String promoCode, double total, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.model.DeliveryAddress deliveryAddress, @org.jetbrains.annotations.Nullable()
    com.example.middlecourseproject.domain.checkout.model.PaymentMethod paymentMethod, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, boolean orderPlaced) {
        super();
    }
    
    public final double getSubtotal() {
        return 0.0;
    }
    
    public final double getBagFee() {
        return 0.0;
    }
    
    public final double getSmallOrderFee() {
        return 0.0;
    }
    
    public final double getServiceFee() {
        return 0.0;
    }
    
    public final double getDeliveryFee() {
        return 0.0;
    }
    
    public final double getTip() {
        return 0.0;
    }
    
    public final double getDiscount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPromoCode() {
        return null;
    }
    
    public final double getTotal() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.model.DeliveryAddress getDeliveryAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.middlecourseproject.domain.checkout.model.PaymentMethod getPaymentMethod() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public final boolean getOrderPlaced() {
        return false;
    }
    
    public CheckoutState() {
        super();
    }
    
    public final double component1() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.domain.checkout.model.DeliveryAddress component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.middlecourseproject.domain.checkout.model.PaymentMethod component11() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.presentation.checkout.viewmodel.CheckoutState copy(double subtotal, double bagFee, double smallOrderFee, double serviceFee, double deliveryFee, double tip, double discount, @org.jetbrains.annotations.Nullable()
    java.lang.String promoCode, double total, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.checkout.model.DeliveryAddress deliveryAddress, @org.jetbrains.annotations.Nullable()
    com.example.middlecourseproject.domain.checkout.model.PaymentMethod paymentMethod, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, boolean orderPlaced) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}