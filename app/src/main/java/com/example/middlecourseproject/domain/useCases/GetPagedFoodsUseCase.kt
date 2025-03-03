package com.example.middlecourseproject.domain.useCases

import androidx.paging.PagingData
import com.example.middlecourseproject.domain.models.Recipe
import com.example.middlecourseproject.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagedFoodsUseCase @Inject constructor(
    private val foodRepository: FoodRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Recipe>> {
        return foodRepository.getPagedFoods(query)
    }
}