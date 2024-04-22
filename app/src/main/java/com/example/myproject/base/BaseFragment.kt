package com.example.myproject.base

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.text.Spanned
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myproject.R
import com.example.myproject.base.navigation.NavigationCommand
import com.example.myproject.ext.delegate.ExceptionHandler
import com.example.myproject.ext.delegate.ExceptionHandlerImpl
import com.example.myproject.ext.delegate.ShowDialog
import com.example.myproject.ext.delegate.ShowDialogImpl
import com.example.myproject.ext.delegate.ShowSnackBarImpl
import com.example.myproject.ext.delegate.ShowSnackBarInterface
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>
    : Fragment(), ExceptionHandler by ExceptionHandlerImpl(), ShowSnackBarInterface by ShowSnackBarImpl(),
    ShowDialog by ShowDialogImpl() {

    abstract val viewModel: VM
    abstract val binding: VB
    abstract val bindingVariable: Int

//    private val progressDialogHelper = ProgressDialogHelper()

    //
//    @Inject lateinit var prefManager: SharedPreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Timber.i("Fragment: Run onCreate")
        setHasOptionsMenu(false)
//        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
//        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
//        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Z, true)
//        returnTransition = MaterialSharedAxis(MaterialSharedAxis.Z, false)
        setupFMListener()

        val navController = findNavController()
        showException(navController)
    }

    override fun onStart() {
        super.onStart()
        viewModel.showToast.observe(this) { Toast.makeText(activity, it, Toast.LENGTH_LONG).show() }
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    override fun onStop() {
        super.onStop()
//        hideLoading()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Timber.i("Fragment: Run onCreateView")
        return binding.root
    }

    private fun performDataBinding() {
        binding.setVariable(bindingVariable, viewModel)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Timber.i("Fragment: Run onViewCreated")
        performDataBinding()
        setupArguments()
        setupAdapter()
        setupViewPager()
        setupComponent()

        setupListener()
        setupObserver()

        initAPI()
        initOnClick()
    }

    protected open fun setupComponent() {}
    protected open fun setupArguments() {}
    protected open fun setupAdapter() {}
    protected open fun setupViewPager() {}

    protected open fun setupListener() {}
    protected open fun setupObserver() {}

    protected open fun initAPI() {}
    protected open fun initOnClick() {}


    protected open fun setupFMListener() {}

    /** Loading */
//    fun showLoading() {
//        this.progressDialogHelper.show(requireContext(), "")
//    }
//
//    fun hideLoading() {
//        progressDialogHelper.dismiss()
//    }

    /** SnackBar */
    private fun showSnackBar(message: String?, spanned: Spanned?, color: String?) {
        var snackbar = Snackbar.make(
            requireContext(),
            this.requireView(),
            getString(R.string.your_error_message),
            Snackbar.LENGTH_SHORT
        )
        message?.let {
            snackbar =
                Snackbar.make(requireContext(), this.requireView(), it, Snackbar.LENGTH_SHORT)
        }
        spanned?.let {
            snackbar =
                Snackbar.make(requireContext(), this.requireView(), it, Snackbar.LENGTH_SHORT)
        }
        color?.let { snackbar.view.setBackgroundColor(Color.parseColor(it)) }
        snackbar.show()
    }

    /** Check Permission */
    fun hasPermission(
        context: Fragment, permissions: Array<String>,
        resLauncher: ActivityResultLauncher<Array<String>>
    ): Boolean {
        var allPermitted = false
        for (permission in permissions) {
            allPermitted = (ContextCompat.checkSelfPermission(context.requireContext(), permission)
                    == PackageManager.PERMISSION_GRANTED)
            if (!allPermitted) break
        }
        if (allPermitted) return true
        resLauncher.launch(permissions)
        return false
    }

    /** Navigate */
    fun navigate(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.To -> findNavController().navigate(command.directions)
            is NavigationCommand.Back -> findNavController().popBackStack()
            is NavigationCommand.BackTo -> findNavController().popBackStack(
                command.destinationId, false
            )

            else -> {}
        }
    }

    /** Keyboard */
    fun hideKeyboard() {
        try {
            val view = requireActivity().currentFocus
            if (view != null) {
                val imm =
                    (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?)
                imm!!.hideSoftInputFromWindow(view.windowToken, 0)
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    interface OnKeyboardVisibilityListener {
        fun onVisibilityChanged(visible: Boolean)
    }

    fun setKeyboardVisibilityListener(
        onKeyboardVisibilityListener: OnKeyboardVisibilityListener,
        view: View
    ) {
        val parentView = (view as ViewGroup)
        parentView.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            private var alreadyOpen = false
            private val defaultKeyboardHeightDP = 100
            private val EstimatedKeyboardDP = defaultKeyboardHeightDP + 48
            private val rect = Rect()

            override fun onGlobalLayout() {
                val estimatedKeyboardHeight = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    EstimatedKeyboardDP.toFloat(),
                    parentView.resources.displayMetrics
                ).toInt()

                parentView.getWindowVisibleDisplayFrame(rect)
                val heightDiff = parentView.rootView.height - (rect.bottom - rect.top)
                val isShown = heightDiff >= estimatedKeyboardHeight
                if (isShown == alreadyOpen) {
                    Timber.i("Keyboard state: Ignoring global layout change...")
                    return
                }
                alreadyOpen = isShown
                onKeyboardVisibilityListener.onVisibilityChanged(isShown)
            }
        })
    }

    /** Back Press */
    fun onBackPressed() {
        requireActivity().onBackPressed()
    }
}