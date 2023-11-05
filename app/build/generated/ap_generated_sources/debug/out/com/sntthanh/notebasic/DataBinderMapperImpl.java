package com.sntthanh.notebasic;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.sntthanh.notebasic.databinding.ActivityAnswerBindingImpl;
import com.sntthanh.notebasic.databinding.ActivityConfilmPincodeBindingImpl;
import com.sntthanh.notebasic.databinding.ActivityCreatePinCodeBindingImpl;
import com.sntthanh.notebasic.databinding.ActivityEnterPincodeBindingImpl;
import com.sntthanh.notebasic.databinding.ActivityInfoUserBindingImpl;
import com.sntthanh.notebasic.databinding.ActivityIntroBindingImpl;
import com.sntthanh.notebasic.databinding.ActivityLanguageBindingImpl;
import com.sntthanh.notebasic.databinding.ActivityQuestionBindingImpl;
import com.sntthanh.notebasic.databinding.DrawerHeaderBindingImpl;
import com.sntthanh.notebasic.databinding.FragmentIntro01BindingImpl;
import com.sntthanh.notebasic.databinding.FragmentIntro02BindingImpl;
import com.sntthanh.notebasic.databinding.FragmentIntro03BindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYANSWER = 1;

  private static final int LAYOUT_ACTIVITYCONFILMPINCODE = 2;

  private static final int LAYOUT_ACTIVITYCREATEPINCODE = 3;

  private static final int LAYOUT_ACTIVITYENTERPINCODE = 4;

  private static final int LAYOUT_ACTIVITYINFOUSER = 5;

  private static final int LAYOUT_ACTIVITYINTRO = 6;

  private static final int LAYOUT_ACTIVITYLANGUAGE = 7;

  private static final int LAYOUT_ACTIVITYQUESTION = 8;

  private static final int LAYOUT_DRAWERHEADER = 9;

  private static final int LAYOUT_FRAGMENTINTRO01 = 10;

  private static final int LAYOUT_FRAGMENTINTRO02 = 11;

  private static final int LAYOUT_FRAGMENTINTRO03 = 12;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(12);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_answer, LAYOUT_ACTIVITYANSWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_confilm_pincode, LAYOUT_ACTIVITYCONFILMPINCODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_create_pin_code, LAYOUT_ACTIVITYCREATEPINCODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_enter_pincode, LAYOUT_ACTIVITYENTERPINCODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_info_user, LAYOUT_ACTIVITYINFOUSER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_intro, LAYOUT_ACTIVITYINTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_language, LAYOUT_ACTIVITYLANGUAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.activity_question, LAYOUT_ACTIVITYQUESTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.drawer_header, LAYOUT_DRAWERHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.fragment_intro_01, LAYOUT_FRAGMENTINTRO01);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.fragment_intro_02, LAYOUT_FRAGMENTINTRO02);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.sntthanh.notebasic.R.layout.fragment_intro_03, LAYOUT_FRAGMENTINTRO03);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYANSWER: {
          if ("layout/activity_answer_0".equals(tag)) {
            return new ActivityAnswerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_answer is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONFILMPINCODE: {
          if ("layout/activity_confilm_pincode_0".equals(tag)) {
            return new ActivityConfilmPincodeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_confilm_pincode is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCREATEPINCODE: {
          if ("layout/activity_create_pin_code_0".equals(tag)) {
            return new ActivityCreatePinCodeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_create_pin_code is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYENTERPINCODE: {
          if ("layout/activity_enter_pincode_0".equals(tag)) {
            return new ActivityEnterPincodeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_enter_pincode is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYINFOUSER: {
          if ("layout/activity_info_user_0".equals(tag)) {
            return new ActivityInfoUserBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_info_user is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYINTRO: {
          if ("layout/activity_intro_0".equals(tag)) {
            return new ActivityIntroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_intro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLANGUAGE: {
          if ("layout/activity_language_0".equals(tag)) {
            return new ActivityLanguageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_language is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYQUESTION: {
          if ("layout/activity_question_0".equals(tag)) {
            return new ActivityQuestionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_question is invalid. Received: " + tag);
        }
        case  LAYOUT_DRAWERHEADER: {
          if ("layout/drawer_header_0".equals(tag)) {
            return new DrawerHeaderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for drawer_header is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINTRO01: {
          if ("layout/fragment_intro_01_0".equals(tag)) {
            return new FragmentIntro01BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_intro_01 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINTRO02: {
          if ("layout/fragment_intro_02_0".equals(tag)) {
            return new FragmentIntro02BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_intro_02 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINTRO03: {
          if ("layout/fragment_intro_03_0".equals(tag)) {
            return new FragmentIntro03BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_intro_03 is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(12);

    static {
      sKeys.put("layout/activity_answer_0", com.sntthanh.notebasic.R.layout.activity_answer);
      sKeys.put("layout/activity_confilm_pincode_0", com.sntthanh.notebasic.R.layout.activity_confilm_pincode);
      sKeys.put("layout/activity_create_pin_code_0", com.sntthanh.notebasic.R.layout.activity_create_pin_code);
      sKeys.put("layout/activity_enter_pincode_0", com.sntthanh.notebasic.R.layout.activity_enter_pincode);
      sKeys.put("layout/activity_info_user_0", com.sntthanh.notebasic.R.layout.activity_info_user);
      sKeys.put("layout/activity_intro_0", com.sntthanh.notebasic.R.layout.activity_intro);
      sKeys.put("layout/activity_language_0", com.sntthanh.notebasic.R.layout.activity_language);
      sKeys.put("layout/activity_question_0", com.sntthanh.notebasic.R.layout.activity_question);
      sKeys.put("layout/drawer_header_0", com.sntthanh.notebasic.R.layout.drawer_header);
      sKeys.put("layout/fragment_intro_01_0", com.sntthanh.notebasic.R.layout.fragment_intro_01);
      sKeys.put("layout/fragment_intro_02_0", com.sntthanh.notebasic.R.layout.fragment_intro_02);
      sKeys.put("layout/fragment_intro_03_0", com.sntthanh.notebasic.R.layout.fragment_intro_03);
    }
  }
}
