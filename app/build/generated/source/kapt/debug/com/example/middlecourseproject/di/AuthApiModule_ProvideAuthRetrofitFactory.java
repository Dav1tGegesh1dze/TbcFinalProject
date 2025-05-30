// Generated by Dagger (https://dagger.dev).
package com.example.middlecourseproject.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
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
public final class AuthApiModule_ProvideAuthRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> clientProvider;

  public AuthApiModule_ProvideAuthRetrofitFactory(Provider<OkHttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return provideAuthRetrofit(clientProvider.get());
  }

  public static AuthApiModule_ProvideAuthRetrofitFactory create(
      Provider<OkHttpClient> clientProvider) {
    return new AuthApiModule_ProvideAuthRetrofitFactory(clientProvider);
  }

  public static Retrofit provideAuthRetrofit(OkHttpClient client) {
    return Preconditions.checkNotNullFromProvides(AuthApiModule.INSTANCE.provideAuthRetrofit(client));
  }
}
