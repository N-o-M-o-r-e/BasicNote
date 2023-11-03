// Generated by view binder compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.ChipGroup;
import com.sntthanh.notebasic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RecyclerBaseNoteBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final MaterialCardView CardView;

  @NonNull
  public final TextView Date;

  @NonNull
  public final TextView ItemsRemaining;

  @NonNull
  public final ChipGroup LabelGroup;

  @NonNull
  public final LinearLayout LinearLayout;

  @NonNull
  public final TextView Note;

  @NonNull
  public final TextView Title;

  private RecyclerBaseNoteBinding(@NonNull FrameLayout rootView, @NonNull MaterialCardView CardView,
      @NonNull TextView Date, @NonNull TextView ItemsRemaining, @NonNull ChipGroup LabelGroup,
      @NonNull LinearLayout LinearLayout, @NonNull TextView Note, @NonNull TextView Title) {
    this.rootView = rootView;
    this.CardView = CardView;
    this.Date = Date;
    this.ItemsRemaining = ItemsRemaining;
    this.LabelGroup = LabelGroup;
    this.LinearLayout = LinearLayout;
    this.Note = Note;
    this.Title = Title;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecyclerBaseNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecyclerBaseNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recycler_base_note, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecyclerBaseNoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.CardView;
      MaterialCardView CardView = ViewBindings.findChildViewById(rootView, id);
      if (CardView == null) {
        break missingId;
      }

      id = R.id.Date;
      TextView Date = ViewBindings.findChildViewById(rootView, id);
      if (Date == null) {
        break missingId;
      }

      id = R.id.ItemsRemaining;
      TextView ItemsRemaining = ViewBindings.findChildViewById(rootView, id);
      if (ItemsRemaining == null) {
        break missingId;
      }

      id = R.id.LabelGroup;
      ChipGroup LabelGroup = ViewBindings.findChildViewById(rootView, id);
      if (LabelGroup == null) {
        break missingId;
      }

      id = R.id.LinearLayout;
      LinearLayout LinearLayout = ViewBindings.findChildViewById(rootView, id);
      if (LinearLayout == null) {
        break missingId;
      }

      id = R.id.Note;
      TextView Note = ViewBindings.findChildViewById(rootView, id);
      if (Note == null) {
        break missingId;
      }

      id = R.id.Title;
      TextView Title = ViewBindings.findChildViewById(rootView, id);
      if (Title == null) {
        break missingId;
      }

      return new RecyclerBaseNoteBinding((FrameLayout) rootView, CardView, Date, ItemsRemaining,
          LabelGroup, LinearLayout, Note, Title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
