// Generated by view binder compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sntthanh.notebasic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogDoYouWantSetPasscodeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton btnOk;

  @NonNull
  public final AppCompatButton btnSkip;

  @NonNull
  public final TextView des;

  @NonNull
  public final TextView title;

  @NonNull
  public final LinearLayout viewChoose;

  private DialogDoYouWantSetPasscodeBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton btnOk, @NonNull AppCompatButton btnSkip, @NonNull TextView des,
      @NonNull TextView title, @NonNull LinearLayout viewChoose) {
    this.rootView = rootView;
    this.btnOk = btnOk;
    this.btnSkip = btnSkip;
    this.des = des;
    this.title = title;
    this.viewChoose = viewChoose;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogDoYouWantSetPasscodeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogDoYouWantSetPasscodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_do_you_want_set_passcode, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogDoYouWantSetPasscodeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnOk;
      AppCompatButton btnOk = ViewBindings.findChildViewById(rootView, id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.btnSkip;
      AppCompatButton btnSkip = ViewBindings.findChildViewById(rootView, id);
      if (btnSkip == null) {
        break missingId;
      }

      id = R.id.des;
      TextView des = ViewBindings.findChildViewById(rootView, id);
      if (des == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.viewChoose;
      LinearLayout viewChoose = ViewBindings.findChildViewById(rootView, id);
      if (viewChoose == null) {
        break missingId;
      }

      return new DialogDoYouWantSetPasscodeBinding((ConstraintLayout) rootView, btnOk, btnSkip, des,
          title, viewChoose);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}