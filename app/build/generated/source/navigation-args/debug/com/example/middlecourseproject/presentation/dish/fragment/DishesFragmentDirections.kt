package com.example.middlecourseproject.presentation.dish.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R

public class DishesFragmentDirections private constructor() {
  public companion object {
    public fun actionDishesFragmentToCartFragment2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dishesFragment_to_cartFragment2)
  }
}
