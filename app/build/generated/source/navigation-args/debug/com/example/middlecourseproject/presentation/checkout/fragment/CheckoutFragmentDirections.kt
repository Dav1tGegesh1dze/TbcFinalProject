package com.example.middlecourseproject.presentation.checkout.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R

public class CheckoutFragmentDirections private constructor() {
  public companion object {
    public fun actionCheckoutFragmentToOrderConfirmationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_checkoutFragment_to_orderConfirmationFragment)

    public fun actionCheckoutFragmentToPaymentFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_checkoutFragment_to_paymentFragment)
  }
}
