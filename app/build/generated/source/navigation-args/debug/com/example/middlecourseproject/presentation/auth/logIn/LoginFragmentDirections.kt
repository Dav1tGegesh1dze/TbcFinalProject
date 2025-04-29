package com.example.middlecourseproject.presentation.auth.logIn

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToRegisterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment)

    public fun actionLoginFragmentToRestaurantFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_restaurantFragment)
  }
}
