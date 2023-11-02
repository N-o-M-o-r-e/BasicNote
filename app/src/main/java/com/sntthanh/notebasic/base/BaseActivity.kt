package com.sntthanh.notebasic.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.github.hariprasanths.bounceview.BounceView
import com.orhanobut.hawk.Hawk

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseActivityWithoutDataBiding<Binding : ViewBinding>(private val inflate: Inflate<Binding>) :
    BaseActivity() {
    protected lateinit var binding: Binding
    private val TAG = "AAAAAAAAAAAAA"
    override fun bindView() {
        binding = inflate(LayoutInflater.from(this), null, false)
        setContentView(binding.root)
    }


}


abstract class BaseActivityWithDataBiding<Binding : ViewDataBinding>(private val inflate: Inflate<Binding>) :
    BaseActivity() {
    protected lateinit var binding: Binding

    override fun bindView() {
        binding = inflate(LayoutInflater.from(this), null, false)
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }
}

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Hawk.init(applicationContext).build()

        var checkOnSaveInstanceState = savedInstanceState
        val TAG = "AAAAAAAAAAAA"
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        with(window) {
            addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            if (isIgnoreTransparent()) {
                setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
            } else {
                setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
                setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS

                )
                clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                statusBarColor = Color.TRANSPARENT
                navigationBarColor = Color.TRANSPARENT
            }
        }


        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        super.onCreate(savedInstanceState)
        bindView()
        initData()
        initView()
        listenLiveData()
        listeners()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    open fun isIgnoreTransparent(): Boolean = false
    protected abstract fun bindView()
    protected abstract fun initData()
    protected abstract fun initView()
    protected abstract fun listenLiveData()
    protected abstract fun listeners()

    fun goToActivityNew(activity: Class<*>, bundle: Bundle) {
        startActivity(Intent(this, activity).putExtra("bundle", bundle))
    }

    fun getBundle(): Bundle? {
        return intent.getBundleExtra("bundle")
    }

    protected fun goToNewActivity(activity: Class<*>) {
        startActivity(Intent(this, activity))
    }

    protected fun goToNewActivity(activity: Class<*>, isFinished: Boolean = false) {
        startActivity(
            Intent(
                this, activity
            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        )

        if (isFinished) {
            finish()
        }
    }

    fun hideView(viewList: List<View>) {
        viewList.forEach {
            it.visibility = View.INVISIBLE
        }
    }

    fun showView(viewList: List<View>) {
        viewList.forEach {
            it.visibility = View.VISIBLE
        }
    }

    protected fun addOrShowFragment(
        fragmentContainerView: Int,
        fragment: Fragment,
        tag: String,
        isRemoveOldFragment: Boolean = false
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentByTag(tag)
        if (currentFragment == null) {
            if (!fragment.isAdded) {
                transaction.add(fragmentContainerView, fragment, tag)
            }
            transaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED)
            transaction.show(fragment)
        } else {
            transaction.setMaxLifecycle(currentFragment, Lifecycle.State.RESUMED)
            transaction.show(currentFragment)
        }
        supportFragmentManager.fragments.forEach {
            if (it.tag != tag) {
                if (isRemoveOldFragment) {
                    transaction.remove(it)
                } else {
                    transaction.hide(it)
                }
                transaction.setMaxLifecycle(it, Lifecycle.State.STARTED)
            }
        }
        transaction.commit()

        Log.d("addOrShowFragment", "${supportFragmentManager.fragments.size}")
    }

    fun addBounceView(listView: List<View>) {
        listView.forEach {
            BounceView.addAnimTo(it).setScaleForPopOutAnim(1.01f, 1.01f)
        }
    }


    protected fun replaceFragment(fragmentContainerView: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(fragmentContainerView, fragment).commit()
    }

    open fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

    open fun getNavigationBarHeight(): Int {
        var result: Int = dpToPx(36)
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        val hasNavBarId = resources.getIdentifier("config_showNavigationBar", "bool", "android")
        if ((ViewConfiguration.get(this)
                .hasPermanentMenuKey() || (hasNavBarId > 0 && resources.getBoolean(hasNavBarId)))
        ) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    open fun marginStatusBar(listView: List<View>) {
        for (i in listView) {
            val params = i.layoutParams as ConstraintLayout.LayoutParams
            params.topMargin = params.topMargin + getStatusBarHeight()
            i.layoutParams = params
        }
    }

    open fun marginNavigationBar(listView: List<View>) {
        for (i in listView) {
            val params = i.layoutParams as ConstraintLayout.LayoutParams
            params.bottomMargin = params.bottomMargin + getNavigationBarHeight()
            i.layoutParams = params
        }
    }


    //hinde keyboard
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    v.clearFocus()
                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            } else {
            }
        }
        return super.dispatchTouchEvent(ev)
    }

}









