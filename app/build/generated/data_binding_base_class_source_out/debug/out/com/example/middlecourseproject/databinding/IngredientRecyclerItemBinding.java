// Generated by view binder compiler. Do not edit!
package com.example.middlecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.middlecourseproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class IngredientRecyclerItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final AppCompatTextView ingredientName;

  private IngredientRecyclerItemBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull AppCompatTextView ingredientName) {
    this.rootView = rootView;
    this.ingredientName = ingredientName;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static IngredientRecyclerItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static IngredientRecyclerItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ingredient_recycler_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static IngredientRecyclerItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ingredientName;
      AppCompatTextView ingredientName = ViewBindings.findChildViewById(rootView, id);
      if (ingredientName == null) {
        break missingId;
      }

      return new IngredientRecyclerItemBinding((LinearLayoutCompat) rootView, ingredientName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
