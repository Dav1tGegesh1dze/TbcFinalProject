package com.example.middlecourseproject.presentation.restaurant.state;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0013J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010(\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010)\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010*\u001a\u00020\u0010H\u00c6\u0003J\t\u0010+\u001a\u00020\u0010H\u00c6\u0003J\u008e\u0001\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u000201H\u00d6\u0001J\t\u00102\u001a\u00020\nH\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001f\u00a8\u00063"}, d2 = {"Lcom/example/middlecourseproject/presentation/restaurant/state/RestaurantState;", "", "categories", "", "Lcom/example/middlecourseproject/domain/restaurant/model/Category;", "restaurants", "Lcom/example/middlecourseproject/domain/restaurant/model/Restaurant;", "adBanners", "Lcom/example/middlecourseproject/domain/restaurant/model/AdBanner;", "selectedCategoryId", "", "userLatitude", "", "userLongitude", "userAddress", "notificationsEnabled", "", "isLoading", "error", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;ZZLjava/lang/String;)V", "getAdBanners", "()Ljava/util/List;", "getCategories", "getError", "()Ljava/lang/String;", "()Z", "getNotificationsEnabled", "getRestaurants", "getSelectedCategoryId", "getUserAddress", "getUserLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getUserLongitude", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;ZZLjava/lang/String;)Lcom/example/middlecourseproject/presentation/restaurant/state/RestaurantState;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class RestaurantState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.middlecourseproject.domain.restaurant.model.Category> categories = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant> restaurants = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner> adBanners = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String selectedCategoryId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double userLatitude = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double userLongitude = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String userAddress = null;
    private final boolean notificationsEnabled = false;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    
    public RestaurantState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.domain.restaurant.model.Category> categories, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant> restaurants, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner> adBanners, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedCategoryId, @org.jetbrains.annotations.Nullable()
    java.lang.Double userLatitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double userLongitude, @org.jetbrains.annotations.Nullable()
    java.lang.String userAddress, boolean notificationsEnabled, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.domain.restaurant.model.Category> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant> getRestaurants() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner> getAdBanners() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedCategoryId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getUserLatitude() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getUserLongitude() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserAddress() {
        return null;
    }
    
    public final boolean getNotificationsEnabled() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public RestaurantState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.domain.restaurant.model.Category> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.presentation.restaurant.state.RestaurantState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.domain.restaurant.model.Category> categories, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.domain.restaurant.model.Restaurant> restaurants, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.domain.restaurant.model.AdBanner> adBanners, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedCategoryId, @org.jetbrains.annotations.Nullable()
    java.lang.Double userLatitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double userLongitude, @org.jetbrains.annotations.Nullable()
    java.lang.String userAddress, boolean notificationsEnabled, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
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