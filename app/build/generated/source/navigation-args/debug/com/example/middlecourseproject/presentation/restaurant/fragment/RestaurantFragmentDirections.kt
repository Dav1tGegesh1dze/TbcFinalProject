package com.example.middlecourseproject.presentation.restaurant.fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.middlecourseproject.R
import com.example.middlecourseproject.domain.restaurant.model.AdBanner
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class RestaurantFragmentDirections private constructor() {
  private data class ActionRestaurantFragmentToDishesFragment(
    public val restaurantId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_restaurantFragment_to_dishesFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("restaurantId", this.restaurantId)
        return result
      }
  }

  private data class ActionRestaurantFragmentToAdDetailFragment(
    public val adBanner: AdBanner,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_restaurantFragment_to_adDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(AdBanner::class.java)) {
          result.putParcelable("adBanner", this.adBanner as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(AdBanner::class.java)) {
          result.putSerializable("adBanner", this.adBanner as Serializable)
        } else {
          throw UnsupportedOperationException(AdBanner::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionRestaurantFragmentToDishesFragment(restaurantId: String): NavDirections =
        ActionRestaurantFragmentToDishesFragment(restaurantId)

    public fun actionRestaurantFragmentToOrderConfirmationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_restaurantFragment_to_orderConfirmationFragment)

    public fun actionRestaurantFragmentToAdDetailFragment(adBanner: AdBanner): NavDirections =
        ActionRestaurantFragmentToAdDetailFragment(adBanner)
  }
}
