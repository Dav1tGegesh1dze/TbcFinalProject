// Generated by Dagger (https://dagger.dev).
package com.example.middlecourseproject.data.utils;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class ApiHelper_Factory implements Factory<ApiHelper> {
  @Override
  public ApiHelper get() {
    return newInstance();
  }

  public static ApiHelper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiHelper newInstance() {
    return new ApiHelper();
  }

  private static final class InstanceHolder {
    private static final ApiHelper_Factory INSTANCE = new ApiHelper_Factory();
  }
}
