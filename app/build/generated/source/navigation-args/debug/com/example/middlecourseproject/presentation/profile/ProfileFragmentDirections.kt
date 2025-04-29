package com.example.middlecourseproject.presentation.profile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileFragmentToRestaurantFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_restaurantFragment)
  }
}
