// Generated by view binder compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.sntthanh.notebasic.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class WidgetListItemBinding implements ViewBinding {
  @NonNull
  private final View rootView;

  @NonNull
  public final View CheckBox;

  private WidgetListItemBinding(@NonNull View rootView, @NonNull View CheckBox) {
    this.rootView = rootView;
    this.CheckBox = CheckBox;
  }

  @Override
  @NonNull
  public View getRoot() {
    return rootView;
  }

  @NonNull
  public static WidgetListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static WidgetListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.widget_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static WidgetListItemBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    View CheckBox = rootView;

    return new WidgetListItemBinding(rootView, CheckBox);
  }
}
