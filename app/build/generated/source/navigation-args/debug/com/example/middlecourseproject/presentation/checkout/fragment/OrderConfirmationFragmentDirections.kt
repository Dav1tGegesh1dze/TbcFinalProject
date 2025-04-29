package com.example.middlecourseproject.presentation.checkout.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R

public class OrderConfirmationFragmentDirections private constructor() {
  public companion object {
    public fun actionOrderConfirmationFragmentToRestaurantFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_orderConfirmationFragment_to_restaurantFragment)
  }
}
