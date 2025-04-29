package com.example.middlecourseproject.presentation.auth.details

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R

public class DetailsFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailsFragmentToRestaurantFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailsFragment_to_restaurantFragment)
  }
}
