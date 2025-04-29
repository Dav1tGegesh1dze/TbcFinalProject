package com.example.middlecourseproject.presentation.auth.register

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R
import kotlin.Int
import kotlin.String

public class RegisterFragmentDirections private constructor() {
  private data class ActionRegisterFragmentToOtpValidation(
    public val email: String,
    public val userName: String,
    public val password: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_registerFragment_to_otpValidation

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("email", this.email)
        result.putString("userName", this.userName)
        result.putString("password", this.password)
        return result
      }
  }

  public companion object {
    public fun actionRegisterFragmentToOtpValidation(
      email: String,
      userName: String,
      password: String,
    ): NavDirections = ActionRegisterFragmentToOtpValidation(email, userName, password)
  }
}
