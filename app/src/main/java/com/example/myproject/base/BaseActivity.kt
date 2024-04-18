package com.example.myproject.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myproject.ext.delegate.ShowDialog
import com.example.myproject.ext.delegate.ShowDialogImpl
import com.example.myproject.ext.delegate.ShowSnackBarImpl
import com.example.myproject.ext.delegate.ShowSnackBarInterface

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(), ShowDialog by ShowDialogImpl(), ShowSnackBarInterface by ShowSnackBarImpl() {

    abstract val binding: VB
    abstract val viewModel: VM
    abstract val bindingVariable: Int

//    private val progressDialogHelper = ProgressDialogHelper()

//    private val baseActivityViewModel: BaseActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Timber.i("Activity: Run onCreate")
        setupBinding()
        onInitViews()
        setupArguments()
        setupComponent()
        setupAdapter()
        setupViewPager()

        setupListener()
        setupObserver()

        initAPI()
        initOnClick()

        setupFMListener()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun setupBinding() {
        setContentView(binding.root)
        binding.setVariable(bindingVariable, viewModel)
        binding.executePendingBindings()
    }

    abstract fun onInitViews()

    protected open fun setupComponent() {}
    protected open fun setupArguments() {}
    protected open fun setupAdapter() {}
    protected open fun setupViewPager() {}

    protected open fun setupListener() {}
    protected open fun setupObserver() {}

    protected open fun initAPI() {}
    protected open fun initOnClick() {}


    protected open fun setupFMListener() {}

//    fun showLoading() {
//        this.progressDialogHelper.show(this, "")
//    }

//    fun hideLoading() {
//        progressDialogHelper.dismiss()
//    }

    fun getNavHost(fragmentContainer: FragmentContainerView): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(fragmentContainer.id) as NavHostFragment
        return navHostFragment.navController
    }


    open fun whiteStatusBarColor(status: Boolean) {
        val color: String = if (status) {
            "#FFFFFF"
        } else {
            "#67BBDF"
        }
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor(color)
    }

    open fun changeStatusBarColor(hexColor: String?) {
        // Color must be in hexadecimal format
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor(hexColor)
    }

    open fun transparentStatusBar() {
        val window = window
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }

}