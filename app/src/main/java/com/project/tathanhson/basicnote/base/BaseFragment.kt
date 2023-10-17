package com.lovetest.find.real.love.finder.base

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

abstract class BaseFragment<Binding : ViewDataBinding>(private val inflate: Inflate<Binding>) :
    Fragment() {
    protected lateinit var binding: Binding
    private lateinit var glide: RequestManager
    val TAG = "AAAAAAAAAAAAAAAA"

    protected abstract fun initData()

    protected abstract fun initView()

    protected abstract fun initViewModel()

    protected abstract fun listenData()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        glide = Glide.with(this)
        initView()
        initData()
        initViewModel()
        listenData()
    }

    fun replaceFragment(res: Int, fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().replace(res, fragment).commit()
    }

    @SuppressLint("DiscouragedApi", "InternalInsetResource")
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

    @SuppressLint("InternalInsetResource")
    open fun getNavigationBarHeight(): Int {
        var result: Int = dpToPx(40)
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        val hasNavBarId = resources.getIdentifier("config_showNavigationBar", "bool", "android")
        if ((ViewConfiguration.get(requireContext())
                .hasPermanentMenuKey() || (hasNavBarId > 0 && resources.getBoolean(hasNavBarId)))
        ) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    protected fun goToNewActivity(activity: Class<*>) {
        startActivity(Intent(requireActivity(), activity))
    }

}