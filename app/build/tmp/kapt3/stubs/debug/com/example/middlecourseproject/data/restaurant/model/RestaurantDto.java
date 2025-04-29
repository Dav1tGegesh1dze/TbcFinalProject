package com.example.middlecourseproject.data.restaurant.model;

@kotlinx.serialization.Serializable()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB\u0095\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017Bi\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f\u00a2\u0006\u0002\u0010\u0018J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fH\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\fH\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00c6\u0003J\t\u00106\u001a\u00020\u0011H\u00c6\u0003J\u0083\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fH\u00c6\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001J\t\u0010<\u001a\u00020\u0005H\u00d6\u0001J&\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u00c1\u0001\u00a2\u0006\u0002\bDR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+\u00a8\u0006G"}, d2 = {"Lcom/example/middlecourseproject/data/restaurant/model/RestaurantDto;", "", "seen1", "", "id", "", "name", "Lcom/example/middlecourseproject/data/restaurant/model/NameDto;", "categoryId", "categoryName", "categoryImage", "rating", "", "mainImage", "additionalImages", "", "location", "Lcom/example/middlecourseproject/data/restaurant/model/LocationDto;", "fullDescription", "menu", "Lcom/example/middlecourseproject/data/restaurant/model/MenuCategoryDto;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/example/middlecourseproject/data/restaurant/model/NameDto;Ljava/lang/String;Lcom/example/middlecourseproject/data/restaurant/model/NameDto;Ljava/lang/String;DLjava/lang/String;Ljava/util/List;Lcom/example/middlecourseproject/data/restaurant/model/LocationDto;Lcom/example/middlecourseproject/data/restaurant/model/NameDto;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/example/middlecourseproject/data/restaurant/model/NameDto;Ljava/lang/String;Lcom/example/middlecourseproject/data/restaurant/model/NameDto;Ljava/lang/String;DLjava/lang/String;Ljava/util/List;Lcom/example/middlecourseproject/data/restaurant/model/LocationDto;Lcom/example/middlecourseproject/data/restaurant/model/NameDto;Ljava/util/List;)V", "getAdditionalImages", "()Ljava/util/List;", "getCategoryId$annotations", "()V", "getCategoryId", "()Ljava/lang/String;", "getCategoryImage", "getCategoryName$annotations", "getCategoryName", "()Lcom/example/middlecourseproject/data/restaurant/model/NameDto;", "getFullDescription", "getId", "getLocation", "()Lcom/example/middlecourseproject/data/restaurant/model/LocationDto;", "getMainImage", "getMenu", "getName", "getRating", "()D", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class RestaurantDto {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.restaurant.model.NameDto name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String categoryId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.restaurant.model.NameDto categoryName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String categoryImage = null;
    private final double rating = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String mainImage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> additionalImages = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.restaurant.model.LocationDto location = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.data.restaurant.model.NameDto fullDescription = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.middlecourseproject.data.restaurant.model.MenuCategoryDto> menu = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.middlecourseproject.data.restaurant.model.RestaurantDto.Companion Companion = null;
    
    public RestaurantDto(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.NameDto name, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.NameDto categoryName, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryImage, double rating, @org.jetbrains.annotations.NotNull()
    java.lang.String mainImage, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> additionalImages, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.LocationDto location, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.NameDto fullDescription, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.data.restaurant.model.MenuCategoryDto> menu) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.NameDto getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryId() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "categoryId")
    @java.lang.Deprecated()
    public static void getCategoryId$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.NameDto getCategoryName() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "categoryName")
    @java.lang.Deprecated()
    public static void getCategoryName$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryImage() {
        return null;
    }
    
    public final double getRating() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMainImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAdditionalImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.LocationDto getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.NameDto getFullDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.data.restaurant.model.MenuCategoryDto> getMenu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.NameDto component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.middlecourseproject.data.restaurant.model.MenuCategoryDto> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.NameDto component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.NameDto component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.LocationDto component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.middlecourseproject.data.restaurant.model.RestaurantDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.NameDto name, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.NameDto categoryName, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryImage, double rating, @org.jetbrains.annotations.NotNull()
    java.lang.String mainImage, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> additionalImages, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.LocationDto location, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.NameDto fullDescription, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.middlecourseproject.data.restaurant.model.MenuCategoryDto> menu) {
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
    
    @kotlin.jvm.JvmStatic()
    public static final void write$Self$app_debug(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.data.restaurant.model.RestaurantDto self, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/example/middlecourseproject/data/restaurant/model/RestaurantDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/example/middlecourseproject/data/restaurant/model/RestaurantDto;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated()
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.example.middlecourseproject.data.restaurant.model.RestaurantDto> {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.middlecourseproject.data.restaurant.model.RestaurantDto.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.example.middlecourseproject.data.restaurant.model.RestaurantDto deserialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override()
        public void serialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull()
        com.example.middlecourseproject.data.restaurant.model.RestaurantDto value) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/example/middlecourseproject/data/restaurant/model/RestaurantDto$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/example/middlecourseproject/data/restaurant/model/RestaurantDto;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.serialization.KSerializer<com.example.middlecourseproject.data.restaurant.model.RestaurantDto> serializer() {
            return null;
        }
    }
}