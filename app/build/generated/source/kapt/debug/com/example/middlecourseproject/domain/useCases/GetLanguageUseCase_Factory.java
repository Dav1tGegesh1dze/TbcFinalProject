// Generated by Dagger (https://dagger.dev).
package com.example.middlecourseproject.domain.useCases;

import com.example.middlecourseproject.domain.repository.LanguageRepository;
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
public final class GetLanguageUseCase_Factory implements Factory<GetLanguageUseCase> {
  private final Provider<LanguageRepository> languageRepositoryProvider;

  public GetLanguageUseCase_Factory(Provider<LanguageRepository> languageRepositoryProvider) {
    this.languageRepositoryProvider = languageRepositoryProvider;
  }

  @Override
  public GetLanguageUseCase get() {
    return newInstance(languageRepositoryProvider.get());
  }

  public static GetLanguageUseCase_Factory create(
      Provider<LanguageRepository> languageRepositoryProvider) {
    return new GetLanguageUseCase_Factory(languageRepositoryProvider);
  }

  public static GetLanguageUseCase newInstance(LanguageRepository languageRepository) {
    return new GetLanguageUseCase(languageRepository);
  }
}
