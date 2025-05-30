// Generated by Dagger (https://dagger.dev).
package com.example.middlecourseproject.domain.checkout.notification;

import com.example.middlecourseproject.domain.checkout.manager.OrderManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class OrderTrackingService_MembersInjector implements MembersInjector<OrderTrackingService> {
  private final Provider<OrderManager> orderManagerProvider;

  public OrderTrackingService_MembersInjector(Provider<OrderManager> orderManagerProvider) {
    this.orderManagerProvider = orderManagerProvider;
  }

  public static MembersInjector<OrderTrackingService> create(
      Provider<OrderManager> orderManagerProvider) {
    return new OrderTrackingService_MembersInjector(orderManagerProvider);
  }

  @Override
  public void injectMembers(OrderTrackingService instance) {
    injectOrderManager(instance, orderManagerProvider.get());
  }

  @InjectedFieldSignature("com.example.middlecourseproject.domain.checkout.notification.OrderTrackingService.orderManager")
  public static void injectOrderManager(OrderTrackingService instance, OrderManager orderManager) {
    instance.orderManager = orderManager;
  }
}
