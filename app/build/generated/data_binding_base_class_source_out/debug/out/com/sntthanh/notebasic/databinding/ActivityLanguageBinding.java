// Generated by data binding compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sntthanh.notebasic.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityLanguageBinding extends ViewDataBinding {
  @NonNull
  public final ImageView btnBack;

  @NonNull
  public final ImageView btnDone;

  @NonNull
  public final RecyclerView scrollView;

  @NonNull
  public final ConstraintLayout statusBar;

  protected ActivityLanguageBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView btnBack, ImageView btnDone, RecyclerView scrollView, ConstraintLayout statusBar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnBack = btnBack;
    this.btnDone = btnDone;
    this.scrollView = scrollView;
    this.statusBar = statusBar;
  }

  @NonNull
  public static ActivityLanguageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_language, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLanguageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityLanguageBinding>inflateInternal(inflater, R.layout.activity_language, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLanguageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_language, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLanguageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityLanguageBinding>inflateInternal(inflater, R.layout.activity_language, null, false, component);
  }

  public static ActivityLanguageBinding bind(@NonNull View view) {
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
  public static ActivityLanguageBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityLanguageBinding)bind(component, view, R.layout.activity_language);
  }
}
