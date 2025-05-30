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
public final class AddPaymentMethodUseCase_Factory implements Factory<AddPaymentMethodUseCase> {
  private final Provider<CheckoutRepository> checkoutRepositoryProvider;

  public AddPaymentMethodUseCase_Factory(Provider<CheckoutRepository> checkoutRepositoryProvider) {
    this.checkoutRepositoryProvider = checkoutRepositoryProvider;
  }

  @Override
  public AddPaymentMethodUseCase get() {
    return newInstance(checkoutRepositoryProvider.get());
  }

  public static AddPaymentMethodUseCase_Factory create(
      Provider<CheckoutRepository> checkoutRepositoryProvider) {
    return new AddPaymentMethodUseCase_Factory(checkoutRepositoryProvider);
  }

  public static AddPaymentMethodUseCase newInstance(CheckoutRepository checkoutRepository) {
    return new AddPaymentMethodUseCase(checkoutRepository);
  }
}
