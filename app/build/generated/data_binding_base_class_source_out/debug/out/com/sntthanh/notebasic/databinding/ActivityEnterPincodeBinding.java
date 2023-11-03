// Generated by data binding compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sntthanh.notebasic.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityEnterPincodeBinding extends ViewDataBinding {
  @NonNull
  public final TextView btnForgetPassword;

  @NonNull
  public final View dot01;

  @NonNull
  public final View dot02;

  @NonNull
  public final View dot03;

  @NonNull
  public final View dot04;

  @NonNull
  public final AppCompatButton pc0;

  @NonNull
  public final AppCompatButton pc1;

  @NonNull
  public final AppCompatButton pc2;

  @NonNull
  public final AppCompatButton pc3;

  @NonNull
  public final AppCompatButton pc4;

  @NonNull
  public final AppCompatButton pc5;

  @NonNull
  public final AppCompatButton pc6;

  @NonNull
  public final AppCompatButton pc7;

  @NonNull
  public final AppCompatButton pc8;

  @NonNull
  public final AppCompatButton pc9;

  @NonNull
  public final AppCompatButton pcClear;

  @NonNull
  public final LinearLayoutCompat statusBar;

  @NonNull
  public final TextView tvDes;

  @NonNull
  public final TextView tvError;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final LinearLayout viewDot;

  @NonNull
  public final ConstraintLayout viewPinCode;

  protected ActivityEnterPincodeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView btnForgetPassword, View dot01, View dot02, View dot03, View dot04,
      AppCompatButton pc0, AppCompatButton pc1, AppCompatButton pc2, AppCompatButton pc3,
      AppCompatButton pc4, AppCompatButton pc5, AppCompatButton pc6, AppCompatButton pc7,
      AppCompatButton pc8, AppCompatButton pc9, AppCompatButton pcClear,
      LinearLayoutCompat statusBar, TextView tvDes, TextView tvError, TextView tvTitle,
      LinearLayout viewDot, ConstraintLayout viewPinCode) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnForgetPassword = btnForgetPassword;
    this.dot01 = dot01;
    this.dot02 = dot02;
    this.dot03 = dot03;
    this.dot04 = dot04;
    this.pc0 = pc0;
    this.pc1 = pc1;
    this.pc2 = pc2;
    this.pc3 = pc3;
    this.pc4 = pc4;
    this.pc5 = pc5;
    this.pc6 = pc6;
    this.pc7 = pc7;
    this.pc8 = pc8;
    this.pc9 = pc9;
    this.pcClear = pcClear;
    this.statusBar = statusBar;
    this.tvDes = tvDes;
    this.tvError = tvError;
    this.tvTitle = tvTitle;
    this.viewDot = viewDot;
    this.viewPinCode = viewPinCode;
  }

  @NonNull
  public static ActivityEnterPincodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_enter_pincode, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityEnterPincodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityEnterPincodeBinding>inflateInternal(inflater, R.layout.activity_enter_pincode, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityEnterPincodeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_enter_pincode, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityEnterPincodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityEnterPincodeBinding>inflateInternal(inflater, R.layout.activity_enter_pincode, null, false, component);
  }

  public static ActivityEnterPincodeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityEnterPincodeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityEnterPincodeBinding)bind(component, view, R.layout.activity_enter_pincode);
  }
}
