// Generated by view binder compiler. Do not edit!
package com.sntthanh.notebasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sntthanh.notebasic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSettingsBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final PreferenceBinding AutoBackup;

  @NonNull
  public final TextView ChangePasscode;

  @NonNull
  public final PreferenceBinding DateFormat;

  @NonNull
  public final TextView ExportBackup;

  @NonNull
  public final TextView GitHub;

  @NonNull
  public final TextView ImportBackup;

  @NonNull
  public final TextView Info;

  @NonNull
  public final TextView Libraries;

  @NonNull
  public final PreferenceSeekbarBinding MaxItems;

  @NonNull
  public final PreferenceSeekbarBinding MaxLines;

  @NonNull
  public final TextView Rate;

  @NonNull
  public final TextView SendFeedback;

  @NonNull
  public final PreferenceBinding TextSize;

  @NonNull
  public final PreferenceBinding Theme;

  @NonNull
  public final PreferenceBinding View;

  @NonNull
  public final SwitchCompat switchTurnPass;

  @NonNull
  public final TextView tvLanguage;

  private FragmentSettingsBinding(@NonNull NestedScrollView rootView,
      @NonNull PreferenceBinding AutoBackup, @NonNull TextView ChangePasscode,
      @NonNull PreferenceBinding DateFormat, @NonNull TextView ExportBackup,
      @NonNull TextView GitHub, @NonNull TextView ImportBackup, @NonNull TextView Info,
      @NonNull TextView Libraries, @NonNull PreferenceSeekbarBinding MaxItems,
      @NonNull PreferenceSeekbarBinding MaxLines, @NonNull TextView Rate,
      @NonNull TextView SendFeedback, @NonNull PreferenceBinding TextSize,
      @NonNull PreferenceBinding Theme, @NonNull PreferenceBinding View,
      @NonNull SwitchCompat switchTurnPass, @NonNull TextView tvLanguage) {
    this.rootView = rootView;
    this.AutoBackup = AutoBackup;
    this.ChangePasscode = ChangePasscode;
    this.DateFormat = DateFormat;
    this.ExportBackup = ExportBackup;
    this.GitHub = GitHub;
    this.ImportBackup = ImportBackup;
    this.Info = Info;
    this.Libraries = Libraries;
    this.MaxItems = MaxItems;
    this.MaxLines = MaxLines;
    this.Rate = Rate;
    this.SendFeedback = SendFeedback;
    this.TextSize = TextSize;
    this.Theme = Theme;
    this.View = View;
    this.switchTurnPass = switchTurnPass;
    this.tvLanguage = tvLanguage;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AutoBackup;
      View AutoBackup = ViewBindings.findChildViewById(rootView, id);
      if (AutoBackup == null) {
        break missingId;
      }
      PreferenceBinding binding_AutoBackup = PreferenceBinding.bind(AutoBackup);

      id = R.id.ChangePasscode;
      TextView ChangePasscode = ViewBindings.findChildViewById(rootView, id);
      if (ChangePasscode == null) {
        break missingId;
      }

      id = R.id.DateFormat;
      View DateFormat = ViewBindings.findChildViewById(rootView, id);
      if (DateFormat == null) {
        break missingId;
      }
      PreferenceBinding binding_DateFormat = PreferenceBinding.bind(DateFormat);

      id = R.id.ExportBackup;
      TextView ExportBackup = ViewBindings.findChildViewById(rootView, id);
      if (ExportBackup == null) {
        break missingId;
      }

      id = R.id.GitHub;
      TextView GitHub = ViewBindings.findChildViewById(rootView, id);
      if (GitHub == null) {
        break missingId;
      }

      id = R.id.ImportBackup;
      TextView ImportBackup = ViewBindings.findChildViewById(rootView, id);
      if (ImportBackup == null) {
        break missingId;
      }

      id = R.id.Info;
      TextView Info = ViewBindings.findChildViewById(rootView, id);
      if (Info == null) {
        break missingId;
      }

      id = R.id.Libraries;
      TextView Libraries = ViewBindings.findChildViewById(rootView, id);
      if (Libraries == null) {
        break missingId;
      }

      id = R.id.MaxItems;
      View MaxItems = ViewBindings.findChildViewById(rootView, id);
      if (MaxItems == null) {
        break missingId;
      }
      PreferenceSeekbarBinding binding_MaxItems = PreferenceSeekbarBinding.bind(MaxItems);

      id = R.id.MaxLines;
      View MaxLines = ViewBindings.findChildViewById(rootView, id);
      if (MaxLines == null) {
        break missingId;
      }
      PreferenceSeekbarBinding binding_MaxLines = PreferenceSeekbarBinding.bind(MaxLines);

      id = R.id.Rate;
      TextView Rate = ViewBindings.findChildViewById(rootView, id);
      if (Rate == null) {
        break missingId;
      }

      id = R.id.SendFeedback;
      TextView SendFeedback = ViewBindings.findChildViewById(rootView, id);
      if (SendFeedback == null) {
        break missingId;
      }

      id = R.id.TextSize;
      View TextSize = ViewBindings.findChildViewById(rootView, id);
      if (TextSize == null) {
        break missingId;
      }
      PreferenceBinding binding_TextSize = PreferenceBinding.bind(TextSize);

      id = R.id.Theme;
      View Theme = ViewBindings.findChildViewById(rootView, id);
      if (Theme == null) {
        break missingId;
      }
      PreferenceBinding binding_Theme = PreferenceBinding.bind(Theme);

      id = R.id.View;
      View View = ViewBindings.findChildViewById(rootView, id);
      if (View == null) {
        break missingId;
      }
      PreferenceBinding binding_View = PreferenceBinding.bind(View);

      id = R.id.switchTurnPass;
      SwitchCompat switchTurnPass = ViewBindings.findChildViewById(rootView, id);
      if (switchTurnPass == null) {
        break missingId;
      }

      id = R.id.tvLanguage;
      TextView tvLanguage = ViewBindings.findChildViewById(rootView, id);
      if (tvLanguage == null) {
        break missingId;
      }

      return new FragmentSettingsBinding((NestedScrollView) rootView, binding_AutoBackup,
          ChangePasscode, binding_DateFormat, ExportBackup, GitHub, ImportBackup, Info, Libraries,
          binding_MaxItems, binding_MaxLines, Rate, SendFeedback, binding_TextSize, binding_Theme,
          binding_View, switchTurnPass, tvLanguage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
