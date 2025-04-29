package com.example.middlecourseproject.domain.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/example/middlecourseproject/domain/utils/ErrorType;", "", "(Ljava/lang/String;I)V", "NOT_CORRECT_EMAIL_OR_PASSWORD", "ALREADY_USED_EMAILADDRESS", "OTP_ERROR_VALID", "OTP_ERROR_CORRECT", "EXPIRED_JWT", "OTHER", "app_debug"})
public enum ErrorType {
    /*public static final*/ NOT_CORRECT_EMAIL_OR_PASSWORD /* = new NOT_CORRECT_EMAIL_OR_PASSWORD() */,
    /*public static final*/ ALREADY_USED_EMAILADDRESS /* = new ALREADY_USED_EMAILADDRESS() */,
    /*public static final*/ OTP_ERROR_VALID /* = new OTP_ERROR_VALID() */,
    /*public static final*/ OTP_ERROR_CORRECT /* = new OTP_ERROR_CORRECT() */,
    /*public static final*/ EXPIRED_JWT /* = new EXPIRED_JWT() */,
    /*public static final*/ OTHER /* = new OTHER() */;
    
    ErrorType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.middlecourseproject.domain.utils.ErrorType> getEntries() {
        return null;
    }
}