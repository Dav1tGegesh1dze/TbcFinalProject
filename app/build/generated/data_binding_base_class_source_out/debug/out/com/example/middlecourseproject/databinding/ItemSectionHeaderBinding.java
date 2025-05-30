// Generated by view binder compiler. Do not edit!
package com.example.middlecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.middlecourseproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemSectionHeaderBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView tvSectionTitle;

  @NonNull
  public final TextView tvSeeAll;

  private ItemSectionHeaderBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView tvSectionTitle, @NonNull TextView tvSeeAll) {
    this.rootView = rootView;
    this.tvSectionTitle = tvSectionTitle;
    this.tvSeeAll = tvSeeAll;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemSectionHeaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemSectionHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_section_header, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemSectionHeaderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvSectionTitle;
      TextView tvSectionTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvSectionTitle == null) {
        break missingId;
      }

      id = R.id.tvSeeAll;
      TextView tvSeeAll = ViewBindings.findChildViewById(rootView, id);
      if (tvSeeAll == null) {
        break missingId;
      }

      return new ItemSectionHeaderBinding((ConstraintLayout) rootView, tvSectionTitle, tvSeeAll);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
