package com.example.middlecourseproject.presentation.restaurant.fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.middlecourseproject.domain.restaurant.model.AdBanner
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class AdDetailFragmentArgs(
  public val adBanner: AdBanner,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(AdBanner::class.java)) {
      result.set("adBanner", this.adBanner as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(AdBanner::class.java)) {
      result.set("adBanner", this.adBanner as Serializable)
    } else {
      throw UnsupportedOperationException(AdBanner::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): AdDetailFragmentArgs {
      bundle.setClassLoader(AdDetailFragmentArgs::class.java.classLoader)
      val __adBanner : AdBanner?
      if (bundle.containsKey("adBanner")) {
        if (Parcelable::class.java.isAssignableFrom(AdBanner::class.java) ||
            Serializable::class.java.isAssignableFrom(AdBanner::class.java)) {
          __adBanner = bundle.get("adBanner") as AdBanner?
        } else {
          throw UnsupportedOperationException(AdBanner::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__adBanner == null) {
          throw IllegalArgumentException("Argument \"adBanner\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"adBanner\" is missing and does not have an android:defaultValue")
      }
      return AdDetailFragmentArgs(__adBanner)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AdDetailFragmentArgs {
      val __adBanner : AdBanner?
      if (savedStateHandle.contains("adBanner")) {
        if (Parcelable::class.java.isAssignableFrom(AdBanner::class.java) ||
            Serializable::class.java.isAssignableFrom(AdBanner::class.java)) {
          __adBanner = savedStateHandle.get<AdBanner?>("adBanner")
        } else {
          throw UnsupportedOperationException(AdBanner::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__adBanner == null) {
          throw IllegalArgumentException("Argument \"adBanner\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"adBanner\" is missing and does not have an android:defaultValue")
      }
      return AdDetailFragmentArgs(__adBanner)
    }
  }
}
