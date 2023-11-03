// Generated by view binder compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sntthanh.notebasic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemLanguageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView languageIcon;

  @NonNull
  public final TextView languageName;

  @NonNull
  public final ConstraintLayout layoutRoot;

  private ItemLanguageBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView languageIcon,
      @NonNull TextView languageName, @NonNull ConstraintLayout layoutRoot) {
    this.rootView = rootView;
    this.languageIcon = languageIcon;
    this.languageName = languageName;
    this.layoutRoot = layoutRoot;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemLanguageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemLanguageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_language, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemLanguageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.language_icon;
      ImageView languageIcon = ViewBindings.findChildViewById(rootView, id);
      if (languageIcon == null) {
        break missingId;
      }

      id = R.id.languageName;
      TextView languageName = ViewBindings.findChildViewById(rootView, id);
      if (languageName == null) {
        break missingId;
      }

      ConstraintLayout layoutRoot = (ConstraintLayout) rootView;

      return new ItemLanguageBinding((ConstraintLayout) rootView, languageIcon, languageName,
          layoutRoot);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}