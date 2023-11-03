package com.sntthanh.notebasic.databinding;
import com.sntthanh.notebasic.R;
import com.sntthanh.notebasic.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityConfilmPincodeBindingImpl extends ActivityConfilmPincodeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.statusBar, 1);
        sViewsWithIds.put(R.id.btnBack, 2);
        sViewsWithIds.put(R.id.tvTitle, 3);
        sViewsWithIds.put(R.id.tvDes, 4);
        sViewsWithIds.put(R.id.tvError, 5);
        sViewsWithIds.put(R.id.viewDot, 6);
        sViewsWithIds.put(R.id.dot01, 7);
        sViewsWithIds.put(R.id.dot02, 8);
        sViewsWithIds.put(R.id.dot03, 9);
        sViewsWithIds.put(R.id.dot04, 10);
        sViewsWithIds.put(R.id.viewPinCode, 11);
        sViewsWithIds.put(R.id.pc_1, 12);
        sViewsWithIds.put(R.id.pc_2, 13);
        sViewsWithIds.put(R.id.pc_3, 14);
        sViewsWithIds.put(R.id.pc_4, 15);
        sViewsWithIds.put(R.id.pc_5, 16);
        sViewsWithIds.put(R.id.pc_6, 17);
        sViewsWithIds.put(R.id.pc_7, 18);
        sViewsWithIds.put(R.id.pc_8, 19);
        sViewsWithIds.put(R.id.pc_9, 20);
        sViewsWithIds.put(R.id.pc_0, 21);
        sViewsWithIds.put(R.id.pc_clear, 22);
        sViewsWithIds.put(R.id.switchToPattern, 23);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityConfilmPincodeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private ActivityConfilmPincodeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            , (android.view.View) bindings[7]
            , (android.view.View) bindings[8]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[10]
            , (androidx.appcompat.widget.AppCompatButton) bindings[21]
            , (androidx.appcompat.widget.AppCompatButton) bindings[12]
            , (androidx.appcompat.widget.AppCompatButton) bindings[13]
            , (androidx.appcompat.widget.AppCompatButton) bindings[14]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[16]
            , (androidx.appcompat.widget.AppCompatButton) bindings[17]
            , (androidx.appcompat.widget.AppCompatButton) bindings[18]
            , (androidx.appcompat.widget.AppCompatButton) bindings[19]
            , (androidx.appcompat.widget.AppCompatButton) bindings[20]
            , (androidx.appcompat.widget.AppCompatButton) bindings[22]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[1]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}