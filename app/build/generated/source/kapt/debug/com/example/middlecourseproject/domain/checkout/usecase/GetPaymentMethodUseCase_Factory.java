// Generated by Dagger (https://dagger.dev).
package com.example.middlecourseproject.domain.checkout.usecase;

import com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

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
public final class GetPaymentMethodUseCase_Factory implements Factory<GetPaymentMethodUseCase> {
  private final Provider<CheckoutRepository> checkoutRepositoryProvider;

  public GetPaymentMethodUseCase_Factory(Provider<CheckoutRepository> checkoutRepositoryProvider) {
    this.checkoutRepositoryProvider = checkoutRepositoryProvider;
  }

  @Override
  public GetPaymentMethodUseCase get() {
    return newInstance(checkoutRepositoryProvider.get());
  }

  public static GetPaymentMethodUseCase_Factory create(
      Provider<CheckoutRepository> checkoutRepositoryProvider) {
    return new GetPaymentMethodUseCase_Factory(checkoutRepositoryProvider);
  }

  public static GetPaymentMethodUseCase newInstance(CheckoutRepository checkoutRepository) {
    return new GetPaymentMethodUseCase(checkoutRepository);
  }
}
