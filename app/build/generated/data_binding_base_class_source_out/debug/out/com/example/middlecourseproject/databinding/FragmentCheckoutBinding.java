// Generated by view binder compiler. Do not edit!
package com.example.middlecourseproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.middlecourseproject.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCheckoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnBack;

  @NonNull
  public final Button btnPlaceOrder;

  @NonNull
  public final ChipGroup chipGroupTip;

  @NonNull
  public final Chip chipTip0;

  @NonNull
  public final Chip chipTip1;

  @NonNull
  public final Chip chipTip3;

  @NonNull
  public final Chip chipTip5;

  @NonNull
  public final Chip chipTipCustom;

  @NonNull
  public final View divider;

  @NonNull
  public final HorizontalScrollView horizontalScroll;

  @NonNull
  public final ImageView ivAddressArrow;

  @NonNull
  public final ImageView ivArrow;

  @NonNull
  public final ImageView ivCardLogo;

  @NonNull
  public final ImageView ivCodeArrow;

  @NonNull
  public final ImageView ivCodeIcon;

  @NonNull
  public final ImageView ivLocationIcon;

  @NonNull
  public final ConstraintLayout layoutDeliveryAddress;

  @NonNull
  public final ConstraintLayout layoutHeader;

  @NonNull
  public final ConstraintLayout layoutPaymentMethod;

  @NonNull
  public final ConstraintLayout layoutRedeemCode;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final Space topSpacer;

  @NonNull
  public final TextView tvAddressCoordinates;

  @NonNull
  public final TextView tvAddressDetails;

  @NonNull
  public final TextView tvBagFee;

  @NonNull
  public final TextView tvBagFeeLabel;

  @NonNull
  public final TextView tvCodeDescription;

  @NonNull
  public final TextView tvDeliveryAddressTitle;

  @NonNull
  public final TextView tvDeliveryFee;

  @NonNull
  public final TextView tvDeliveryFeeLabel;

  @NonNull
  public final TextView tvHowFeesWork;

  @NonNull
  public final TextView tvPaymentAmount;

  @NonNull
  public final TextView tvPaymentMethod;

  @NonNull
  public final TextView tvPaymentTitle;

  @NonNull
  public final TextView tvRedeemCode;

  @NonNull
  public final TextView tvServiceFee;

  @NonNull
  public final TextView tvServiceFeeLabel;

  @NonNull
  public final TextView tvSmallOrderFee;

  @NonNull
  public final TextView tvSmallOrderFeeLabel;

  @NonNull
  public final TextView tvSubtotal;

  @NonNull
  public final TextView tvSubtotalLabel;

  @NonNull
  public final TextView tvSummaryDescription;

  @NonNull
  public final TextView tvSummaryTitle;

  @NonNull
  public final TextView tvTipDescription;

  @NonNull
  public final TextView tvTipTitle;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvTotal;

  @NonNull
  public final TextView tvTotalLabel;

  private FragmentCheckoutBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton btnBack,
      @NonNull Button btnPlaceOrder, @NonNull ChipGroup chipGroupTip, @NonNull Chip chipTip0,
      @NonNull Chip chipTip1, @NonNull Chip chipTip3, @NonNull Chip chipTip5,
      @NonNull Chip chipTipCustom, @NonNull View divider,
      @NonNull HorizontalScrollView horizontalScroll, @NonNull ImageView ivAddressArrow,
      @NonNull ImageView ivArrow, @NonNull ImageView ivCardLogo, @NonNull ImageView ivCodeArrow,
      @NonNull ImageView ivCodeIcon, @NonNull ImageView ivLocationIcon,
      @NonNull ConstraintLayout layoutDeliveryAddress, @NonNull ConstraintLayout layoutHeader,
      @NonNull ConstraintLayout layoutPaymentMethod, @NonNull ConstraintLayout layoutRedeemCode,
      @NonNull ProgressBar progressBar, @NonNull Space topSpacer,
      @NonNull TextView tvAddressCoordinates, @NonNull TextView tvAddressDetails,
      @NonNull TextView tvBagFee, @NonNull TextView tvBagFeeLabel,
      @NonNull TextView tvCodeDescription, @NonNull TextView tvDeliveryAddressTitle,
      @NonNull TextView tvDeliveryFee, @NonNull TextView tvDeliveryFeeLabel,
      @NonNull TextView tvHowFeesWork, @NonNull TextView tvPaymentAmount,
      @NonNull TextView tvPaymentMethod, @NonNull TextView tvPaymentTitle,
      @NonNull TextView tvRedeemCode, @NonNull TextView tvServiceFee,
      @NonNull TextView tvServiceFeeLabel, @NonNull TextView tvSmallOrderFee,
      @NonNull TextView tvSmallOrderFeeLabel, @NonNull TextView tvSubtotal,
      @NonNull TextView tvSubtotalLabel, @NonNull TextView tvSummaryDescription,
      @NonNull TextView tvSummaryTitle, @NonNull TextView tvTipDescription,
      @NonNull TextView tvTipTitle, @NonNull TextView tvTitle, @NonNull TextView tvTotal,
      @NonNull TextView tvTotalLabel) {
    this.rootView = rootView;
    this.btnBack = btnBack;
    this.btnPlaceOrder = btnPlaceOrder;
    this.chipGroupTip = chipGroupTip;
    this.chipTip0 = chipTip0;
    this.chipTip1 = chipTip1;
    this.chipTip3 = chipTip3;
    this.chipTip5 = chipTip5;
    this.chipTipCustom = chipTipCustom;
    this.divider = divider;
    this.horizontalScroll = horizontalScroll;
    this.ivAddressArrow = ivAddressArrow;
    this.ivArrow = ivArrow;
    this.ivCardLogo = ivCardLogo;
    this.ivCodeArrow = ivCodeArrow;
    this.ivCodeIcon = ivCodeIcon;
    this.ivLocationIcon = ivLocationIcon;
    this.layoutDeliveryAddress = layoutDeliveryAddress;
    this.layoutHeader = layoutHeader;
    this.layoutPaymentMethod = layoutPaymentMethod;
    this.layoutRedeemCode = layoutRedeemCode;
    this.progressBar = progressBar;
    this.topSpacer = topSpacer;
    this.tvAddressCoordinates = tvAddressCoordinates;
    this.tvAddressDetails = tvAddressDetails;
    this.tvBagFee = tvBagFee;
    this.tvBagFeeLabel = tvBagFeeLabel;
    this.tvCodeDescription = tvCodeDescription;
    this.tvDeliveryAddressTitle = tvDeliveryAddressTitle;
    this.tvDeliveryFee = tvDeliveryFee;
    this.tvDeliveryFeeLabel = tvDeliveryFeeLabel;
    this.tvHowFeesWork = tvHowFeesWork;
    this.tvPaymentAmount = tvPaymentAmount;
    this.tvPaymentMethod = tvPaymentMethod;
    this.tvPaymentTitle = tvPaymentTitle;
    this.tvRedeemCode = tvRedeemCode;
    this.tvServiceFee = tvServiceFee;
    this.tvServiceFeeLabel = tvServiceFeeLabel;
    this.tvSmallOrderFee = tvSmallOrderFee;
    this.tvSmallOrderFeeLabel = tvSmallOrderFeeLabel;
    this.tvSubtotal = tvSubtotal;
    this.tvSubtotalLabel = tvSubtotalLabel;
    this.tvSummaryDescription = tvSummaryDescription;
    this.tvSummaryTitle = tvSummaryTitle;
    this.tvTipDescription = tvTipDescription;
    this.tvTipTitle = tvTipTitle;
    this.tvTitle = tvTitle;
    this.tvTotal = tvTotal;
    this.tvTotalLabel = tvTotalLabel;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCheckoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCheckoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_checkout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCheckoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBack;
      ImageButton btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.btnPlaceOrder;
      Button btnPlaceOrder = ViewBindings.findChildViewById(rootView, id);
      if (btnPlaceOrder == null) {
        break missingId;
      }

      id = R.id.chipGroupTip;
      ChipGroup chipGroupTip = ViewBindings.findChildViewById(rootView, id);
      if (chipGroupTip == null) {
        break missingId;
      }

      id = R.id.chipTip0;
      Chip chipTip0 = ViewBindings.findChildViewById(rootView, id);
      if (chipTip0 == null) {
        break missingId;
      }

      id = R.id.chipTip1;
      Chip chipTip1 = ViewBindings.findChildViewById(rootView, id);
      if (chipTip1 == null) {
        break missingId;
      }

      id = R.id.chipTip3;
      Chip chipTip3 = ViewBindings.findChildViewById(rootView, id);
      if (chipTip3 == null) {
        break missingId;
      }

      id = R.id.chipTip5;
      Chip chipTip5 = ViewBindings.findChildViewById(rootView, id);
      if (chipTip5 == null) {
        break missingId;
      }

      id = R.id.chipTipCustom;
      Chip chipTipCustom = ViewBindings.findChildViewById(rootView, id);
      if (chipTipCustom == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.horizontalScroll;
      HorizontalScrollView horizontalScroll = ViewBindings.findChildViewById(rootView, id);
      if (horizontalScroll == null) {
        break missingId;
      }

      id = R.id.ivAddressArrow;
      ImageView ivAddressArrow = ViewBindings.findChildViewById(rootView, id);
      if (ivAddressArrow == null) {
        break missingId;
      }

      id = R.id.ivArrow;
      ImageView ivArrow = ViewBindings.findChildViewById(rootView, id);
      if (ivArrow == null) {
        break missingId;
      }

      id = R.id.ivCardLogo;
      ImageView ivCardLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivCardLogo == null) {
        break missingId;
      }

      id = R.id.ivCodeArrow;
      ImageView ivCodeArrow = ViewBindings.findChildViewById(rootView, id);
      if (ivCodeArrow == null) {
        break missingId;
      }

      id = R.id.ivCodeIcon;
      ImageView ivCodeIcon = ViewBindings.findChildViewById(rootView, id);
      if (ivCodeIcon == null) {
        break missingId;
      }

      id = R.id.ivLocationIcon;
      ImageView ivLocationIcon = ViewBindings.findChildViewById(rootView, id);
      if (ivLocationIcon == null) {
        break missingId;
      }

      id = R.id.layoutDeliveryAddress;
      ConstraintLayout layoutDeliveryAddress = ViewBindings.findChildViewById(rootView, id);
      if (layoutDeliveryAddress == null) {
        break missingId;
      }

      id = R.id.layoutHeader;
      ConstraintLayout layoutHeader = ViewBindings.findChildViewById(rootView, id);
      if (layoutHeader == null) {
        break missingId;
      }

      id = R.id.layoutPaymentMethod;
      ConstraintLayout layoutPaymentMethod = ViewBindings.findChildViewById(rootView, id);
      if (layoutPaymentMethod == null) {
        break missingId;
      }

      id = R.id.layoutRedeemCode;
      ConstraintLayout layoutRedeemCode = ViewBindings.findChildViewById(rootView, id);
      if (layoutRedeemCode == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.topSpacer;
      Space topSpacer = ViewBindings.findChildViewById(rootView, id);
      if (topSpacer == null) {
        break missingId;
      }

      id = R.id.tvAddressCoordinates;
      TextView tvAddressCoordinates = ViewBindings.findChildViewById(rootView, id);
      if (tvAddressCoordinates == null) {
        break missingId;
      }

      id = R.id.tvAddressDetails;
      TextView tvAddressDetails = ViewBindings.findChildViewById(rootView, id);
      if (tvAddressDetails == null) {
        break missingId;
      }

      id = R.id.tvBagFee;
      TextView tvBagFee = ViewBindings.findChildViewById(rootView, id);
      if (tvBagFee == null) {
        break missingId;
      }

      id = R.id.tvBagFeeLabel;
      TextView tvBagFeeLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvBagFeeLabel == null) {
        break missingId;
      }

      id = R.id.tvCodeDescription;
      TextView tvCodeDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvCodeDescription == null) {
        break missingId;
      }

      id = R.id.tvDeliveryAddressTitle;
      TextView tvDeliveryAddressTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvDeliveryAddressTitle == null) {
        break missingId;
      }

      id = R.id.tvDeliveryFee;
      TextView tvDeliveryFee = ViewBindings.findChildViewById(rootView, id);
      if (tvDeliveryFee == null) {
        break missingId;
      }

      id = R.id.tvDeliveryFeeLabel;
      TextView tvDeliveryFeeLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvDeliveryFeeLabel == null) {
        break missingId;
      }

      id = R.id.tvHowFeesWork;
      TextView tvHowFeesWork = ViewBindings.findChildViewById(rootView, id);
      if (tvHowFeesWork == null) {
        break missingId;
      }

      id = R.id.tvPaymentAmount;
      TextView tvPaymentAmount = ViewBindings.findChildViewById(rootView, id);
      if (tvPaymentAmount == null) {
        break missingId;
      }

      id = R.id.tvPaymentMethod;
      TextView tvPaymentMethod = ViewBindings.findChildViewById(rootView, id);
      if (tvPaymentMethod == null) {
        break missingId;
      }

      id = R.id.tvPaymentTitle;
      TextView tvPaymentTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvPaymentTitle == null) {
        break missingId;
      }

      id = R.id.tvRedeemCode;
      TextView tvRedeemCode = ViewBindings.findChildViewById(rootView, id);
      if (tvRedeemCode == null) {
        break missingId;
      }

      id = R.id.tvServiceFee;
      TextView tvServiceFee = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceFee == null) {
        break missingId;
      }

      id = R.id.tvServiceFeeLabel;
      TextView tvServiceFeeLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvServiceFeeLabel == null) {
        break missingId;
      }

      id = R.id.tvSmallOrderFee;
      TextView tvSmallOrderFee = ViewBindings.findChildViewById(rootView, id);
      if (tvSmallOrderFee == null) {
        break missingId;
      }

      id = R.id.tvSmallOrderFeeLabel;
      TextView tvSmallOrderFeeLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvSmallOrderFeeLabel == null) {
        break missingId;
      }

      id = R.id.tvSubtotal;
      TextView tvSubtotal = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotal == null) {
        break missingId;
      }

      id = R.id.tvSubtotalLabel;
      TextView tvSubtotalLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotalLabel == null) {
        break missingId;
      }

      id = R.id.tvSummaryDescription;
      TextView tvSummaryDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvSummaryDescription == null) {
        break missingId;
      }

      id = R.id.tvSummaryTitle;
      TextView tvSummaryTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvSummaryTitle == null) {
        break missingId;
      }

      id = R.id.tvTipDescription;
      TextView tvTipDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvTipDescription == null) {
        break missingId;
      }

      id = R.id.tvTipTitle;
      TextView tvTipTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTipTitle == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      id = R.id.tvTotal;
      TextView tvTotal = ViewBindings.findChildViewById(rootView, id);
      if (tvTotal == null) {
        break missingId;
      }

      id = R.id.tvTotalLabel;
      TextView tvTotalLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalLabel == null) {
        break missingId;
      }

      return new FragmentCheckoutBinding((ConstraintLayout) rootView, btnBack, btnPlaceOrder,
          chipGroupTip, chipTip0, chipTip1, chipTip3, chipTip5, chipTipCustom, divider,
          horizontalScroll, ivAddressArrow, ivArrow, ivCardLogo, ivCodeArrow, ivCodeIcon,
          ivLocationIcon, layoutDeliveryAddress, layoutHeader, layoutPaymentMethod,
          layoutRedeemCode, progressBar, topSpacer, tvAddressCoordinates, tvAddressDetails,
          tvBagFee, tvBagFeeLabel, tvCodeDescription, tvDeliveryAddressTitle, tvDeliveryFee,
          tvDeliveryFeeLabel, tvHowFeesWork, tvPaymentAmount, tvPaymentMethod, tvPaymentTitle,
          tvRedeemCode, tvServiceFee, tvServiceFeeLabel, tvSmallOrderFee, tvSmallOrderFeeLabel,
          tvSubtotal, tvSubtotalLabel, tvSummaryDescription, tvSummaryTitle, tvTipDescription,
          tvTipTitle, tvTitle, tvTotal, tvTotalLabel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
