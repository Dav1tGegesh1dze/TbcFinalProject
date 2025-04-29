package com.example.middlecourseproject.presentation.auth.otpValidation

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R

public class OtpValidationFragmentDirections private constructor() {
  public companion object {
    public fun actionOtpValidationToDetailsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_otpValidation_to_detailsFragment)
  }
}
