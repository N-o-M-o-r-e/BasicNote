// Generated by view binder compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sntthanh.notebasic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogInputBinding implements ViewBinding {
  @NonNull
  private final TextInputLayout rootView;

  @NonNull
  public final TextInputEditText EditText;

  private DialogInputBinding(@NonNull TextInputLayout rootView,
      @NonNull TextInputEditText EditText) {
    this.rootView = rootView;
    this.EditText = EditText;
  }

  @Override
  @NonNull
  public TextInputLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogInputBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogInputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_input, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogInputBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.EditText;
      TextInputEditText EditText = ViewBindings.findChildViewById(rootView, id);
      if (EditText == null) {
        break missingId;
      }

      return new DialogInputBinding((TextInputLayout) rootView, EditText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
