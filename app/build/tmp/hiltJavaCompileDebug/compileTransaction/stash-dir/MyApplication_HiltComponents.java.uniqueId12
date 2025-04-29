package com.example.middlecourseproject;

import com.example.middlecourseproject.di.AuthApiModule;
import com.example.middlecourseproject.di.BaseNetworkModule;
import com.example.middlecourseproject.di.CartModule;
import com.example.middlecourseproject.di.CoroutineDispatcherModule;
import com.example.middlecourseproject.di.DatabaseModule;
import com.example.middlecourseproject.di.FirebaseModule;
import com.example.middlecourseproject.di.FoodApiModule;
import com.example.middlecourseproject.di.LocaleHelperEntryPoint;
import com.example.middlecourseproject.di.RepositoryModule;
import com.example.middlecourseproject.di.SearchModule;
import com.example.middlecourseproject.di.SerializationModule;
import com.example.middlecourseproject.di.SessionModule;
import com.example.middlecourseproject.di.UtilsModule;
import com.example.middlecourseproject.di.checkout.CheckoutUseCasesModule;
import com.example.middlecourseproject.di.restaurant.AppModule;
import com.example.middlecourseproject.domain.checkout.notification.BootReceiver_GeneratedInjector;
import com.example.middlecourseproject.domain.checkout.notification.MyFirebaseMessagingService_GeneratedInjector;
import com.example.middlecourseproject.domain.checkout.notification.OrderTrackingService_GeneratedInjector;
import com.example.middlecourseproject.presentation.auth.logIn.LoginFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.auth.logIn.LoginViewModel_HiltModules;
import com.example.middlecourseproject.presentation.auth.register.RegisterFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.auth.register.RegisterViewModel_HiltModules;
import com.example.middlecourseproject.presentation.base.MainActivity_GeneratedInjector;
import com.example.middlecourseproject.presentation.cart.fragment.CartFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.cart.viewmodel.CartViewModel_HiltModules;
import com.example.middlecourseproject.presentation.checkout.fragment.CheckoutFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.checkout.fragment.OrderConfirmationFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.checkout.fragment.PaymentFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.checkout.viewmodel.CheckoutViewModel_HiltModules;
import com.example.middlecourseproject.presentation.checkout.viewmodel.PaymentViewModel_HiltModules;
import com.example.middlecourseproject.presentation.dish.fragment.DishesFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.dish.viewmodel.DishesViewModel_HiltModules;
import com.example.middlecourseproject.presentation.profile.ProfileFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.profile.ProfileViewModel_HiltModules;
import com.example.middlecourseproject.presentation.restaurant.fragment.AdDetailFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.restaurant.fragment.RestaurantFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.restaurant.viewmodel.RestaurantViewModel_HiltModules;
import com.example.middlecourseproject.presentation.search.fragment.SearchFragment_GeneratedInjector;
import com.example.middlecourseproject.presentation.search.viewmodel.SearchViewModel_HiltModules;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.HiltWrapper_SavedStateHandleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.inject.Singleton;

public final class MyApplication_HiltComponents {
  private MyApplication_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          AppModule.class,
          ApplicationContextModule.class,
          AuthApiModule.class,
          BaseNetworkModule.class,
          CartModule.class,
          CheckoutUseCasesModule.class,
          CoroutineDispatcherModule.class,
          DatabaseModule.class,
          FirebaseModule.class,
          FoodApiModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class,
          RepositoryModule.class,
          SearchModule.class,
          SerializationModule.class,
          SessionModule.class,
          UtilsModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements MyApplication_GeneratedInjector,
      LocaleHelperEntryPoint,
      BootReceiver_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements MyFirebaseMessagingService_GeneratedInjector,
      OrderTrackingService_GeneratedInjector,
      ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          CartViewModel_HiltModules.KeyModule.class,
          CheckoutViewModel_HiltModules.KeyModule.class,
          DishesViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          HiltWrapper_SavedStateHandleModule.class,
          LoginViewModel_HiltModules.KeyModule.class,
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          PaymentViewModel_HiltModules.KeyModule.class,
          ProfileViewModel_HiltModules.KeyModule.class,
          RegisterViewModel_HiltModules.KeyModule.class,
          RestaurantViewModel_HiltModules.KeyModule.class,
          SearchViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class,
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements MainActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          CartViewModel_HiltModules.BindsModule.class,
          CheckoutViewModel_HiltModules.BindsModule.class,
          DishesViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          LoginViewModel_HiltModules.BindsModule.class,
          PaymentViewModel_HiltModules.BindsModule.class,
          ProfileViewModel_HiltModules.BindsModule.class,
          RegisterViewModel_HiltModules.BindsModule.class,
          RestaurantViewModel_HiltModules.BindsModule.class,
          SearchViewModel_HiltModules.BindsModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements LoginFragment_GeneratedInjector,
      RegisterFragment_GeneratedInjector,
      CartFragment_GeneratedInjector,
      CheckoutFragment_GeneratedInjector,
      OrderConfirmationFragment_GeneratedInjector,
      PaymentFragment_GeneratedInjector,
      DishesFragment_GeneratedInjector,
      ProfileFragment_GeneratedInjector,
      AdDetailFragment_GeneratedInjector,
      RestaurantFragment_GeneratedInjector,
      SearchFragment_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
