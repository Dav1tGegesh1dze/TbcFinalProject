// Generated by view binder compiler. Do not edit!
package com.example.middlecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.middlecourseproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCartBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnBack;

  @NonNull
  public final Button btnCheckout;

  @NonNull
  public final View divider;

  @NonNull
  public final Group groupCartContent;

  @NonNull
  public final Group groupEmptyCart;

  @NonNull
  public final ImageView ivEmptyCart;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView rvCartItems;

  @NonNull
  public final Space topSpacer;

  @NonNull
  public final TextView tvCartTitle;

  @NonNull
  public final TextView tvEmptyCartMessage;

  @NonNull
  public final TextView tvTotalLabel;

  @NonNull
  public final TextView tvTotalPrice;

  private FragmentCartBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton btnBack,
      @NonNull Button btnCheckout, @NonNull View divider, @NonNull Group groupCartContent,
      @NonNull Group groupEmptyCart, @NonNull ImageView ivEmptyCart,
      @NonNull ProgressBar progressBar, @NonNull RecyclerView rvCartItems, @NonNull Space topSpacer,
      @NonNull TextView tvCartTitle, @NonNull TextView tvEmptyCartMessage,
      @NonNull TextView tvTotalLabel, @NonNull TextView tvTotalPrice) {
    this.rootView = rootView;
    this.btnBack = btnBack;
    this.btnCheckout = btnCheckout;
    this.divider = divider;
    this.groupCartContent = groupCartContent;
    this.groupEmptyCart = groupEmptyCart;
    this.ivEmptyCart = ivEmptyCart;
    this.progressBar = progressBar;
    this.rvCartItems = rvCartItems;
    this.topSpacer = topSpacer;
    this.tvCartTitle = tvCartTitle;
    this.tvEmptyCartMessage = tvEmptyCartMessage;
    this.tvTotalLabel = tvTotalLabel;
    this.tvTotalPrice = tvTotalPrice;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCartBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_cart, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBack;
      ImageButton btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.btnCheckout;
      Button btnCheckout = ViewBindings.findChildViewById(rootView, id);
      if (btnCheckout == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.groupCartContent;
      Group groupCartContent = ViewBindings.findChildViewById(rootView, id);
      if (groupCartContent == null) {
        break missingId;
      }

      id = R.id.groupEmptyCart;
      Group groupEmptyCart = ViewBindings.findChildViewById(rootView, id);
      if (groupEmptyCart == null) {
        break missingId;
      }

      id = R.id.ivEmptyCart;
      ImageView ivEmptyCart = ViewBindings.findChildViewById(rootView, id);
      if (ivEmptyCart == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.rvCartItems;
      RecyclerView rvCartItems = ViewBindings.findChildViewById(rootView, id);
      if (rvCartItems == null) {
        break missingId;
      }

      id = R.id.topSpacer;
      Space topSpacer = ViewBindings.findChildViewById(rootView, id);
      if (topSpacer == null) {
        break missingId;
      }

      id = R.id.tvCartTitle;
      TextView tvCartTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvCartTitle == null) {
        break missingId;
      }

      id = R.id.tvEmptyCartMessage;
      TextView tvEmptyCartMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvEmptyCartMessage == null) {
        break missingId;
      }

      id = R.id.tvTotalLabel;
      TextView tvTotalLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalLabel == null) {
        break missingId;
      }

      id = R.id.tvTotalPrice;
      TextView tvTotalPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalPrice == null) {
        break missingId;
      }

      return new FragmentCartBinding((ConstraintLayout) rootView, btnBack, btnCheckout, divider,
          groupCartContent, groupEmptyCart, ivEmptyCart, progressBar, rvCartItems, topSpacer,
          tvCartTitle, tvEmptyCartMessage, tvTotalLabel, tvTotalPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
