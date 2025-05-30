// Generated by Dagger (https://dagger.dev).
package com.example.middlecourseproject.di;

import com.example.middlecourseproject.data.remote.services.ProfileService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.example.middlecourseproject.di.AuthRetrofit")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AuthApiModule_ProvideProfileServiceFactory implements Factory<ProfileService> {
  private final Provider<Retrofit> retrofitProvider;

  public AuthApiModule_ProvideProfileServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ProfileService get() {
    return provideProfileService(retrofitProvider.get());
  }

  public static AuthApiModule_ProvideProfileServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AuthApiModule_ProvideProfileServiceFactory(retrofitProvider);
  }

  public static ProfileService provideProfileService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AuthApiModule.INSTANCE.provideProfileService(retrofit));
  }
}
