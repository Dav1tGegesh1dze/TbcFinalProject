package com.example.middlecourseproject.presentation.search.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/example/middlecourseproject/presentation/search/viewmodel/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "getRestaurantsByCategoryUseCase", "Lcom/example/middlecourseproject/domain/restaurant/usecase/GetRestaurantsByCategoryUseCase;", "searchUseCase", "Lcom/example/middlecourseproject/domain/search/usecase/SearchUseCase;", "(Lcom/example/middlecourseproject/domain/restaurant/usecase/GetRestaurantsByCategoryUseCase;Lcom/example/middlecourseproject/domain/search/usecase/SearchUseCase;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/middlecourseproject/presentation/search/state/SearchState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearSearch", "", "loadAllRestaurants", "loadPopularSearches", "onEvent", "event", "Lcom/example/middlecourseproject/presentation/search/event/SearchEvent;", "search", "query", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantsByCategoryUseCase getRestaurantsByCategoryUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.middlecourseproject.domain.search.usecase.SearchUseCase searchUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.middlecourseproject.presentation.search.state.SearchState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.search.state.SearchState> state = null;
    
    @javax.inject.Inject()
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.restaurant.usecase.GetRestaurantsByCategoryUseCase getRestaurantsByCategoryUseCase, @org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.domain.search.usecase.SearchUseCase searchUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.middlecourseproject.presentation.search.state.SearchState> getState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.example.middlecourseproject.presentation.search.event.SearchEvent event) {
    }
    
    private final void loadPopularSearches() {
    }
    
    private final void loadAllRestaurants() {
    }
    
    private final void search(java.lang.String query) {
    }
    
    private final void clearSearch() {
    }
}