package com.example.myproject.ext.delegate

interface ShowSnackBarInterface {
//    fun showSnackBarTop(
//        context: Context,
//        component: View,
//        status: String,
//        imageStatus: Int,
//        title: String,
//        desc: String,
//        activity: FragmentActivity
//    )
//
//    fun showSnackBarOrder(
//        context: Context,
//        component: View,
//        buySell: String,
//        stockCode: String,
//        status: String,
//        lotSize: String,
//        price: Double
//    )
}

class ShowSnackBarImpl : ShowSnackBarInterface {
//    override fun showSnackBarTop(
//        context: Context,
//        component: View,
//        status: String,
//        imageStatus: Int,
//        title: String,
//        desc: String,
//        activity: FragmentActivity
//    ) {
//        val binding = CustomSnackbarTopBinding.inflate(LayoutInflater.from(context))
//        val snackbar = Snackbar.make(component, "", Snackbar.LENGTH_LONG)
//
//        // Set SnackBar From Top Of The Screen
//        if (snackbar.view.layoutParams is FrameLayout.LayoutParams) {
//            val params = snackbar.view.layoutParams as FrameLayout.LayoutParams
//            params.gravity = Gravity.TOP
//            snackbar.view.layoutParams = params
//        } else if (snackbar.view.layoutParams is CoordinatorLayout.LayoutParams) {
//            val params = snackbar.view.layoutParams as CoordinatorLayout.LayoutParams
//            params.gravity = Gravity.TOP
//            snackbar.view.layoutParams = params
//        }
//
//        binding.tvTitle.text = title
//
//        if (desc != null && desc != "") {
//            binding.tvDesc.visibility = View.VISIBLE
//            binding.tvDesc.text = desc
//        } else {
//            binding.tvDesc.visibility = View.GONE
//        }
//
//        binding.ivStatus.setImageResource(imageStatus)
//
//        when (status) {
//            "success" -> {
//                binding.clCustomSnackbarTop.setBackgroundResource(R.drawable.bg_light_green_border_green)
//                val tintColor = ContextCompat.getColor(context, R.color.green)
//                binding.ivStatus.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.btnClose.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.green))
//            }
//
//            "info" -> {
//                binding.clCustomSnackbarTop.setBackgroundResource(R.drawable.bg_light_blue_border_blue)
//                val tintColor = ContextCompat.getColor(context, R.color.blue)
//                binding.ivStatus.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.btnClose.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.blue))
//            }
//
//            "warning" -> {
//                binding.clCustomSnackbarTop.setBackgroundResource(R.drawable.bg_light_yellow_border_yellow)
//                val tintColor = ContextCompat.getColor(context, R.color.yellow)
//                binding.ivStatus.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.btnClose.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.yellow))
//            }
//
//            "error" -> {
//                binding.clCustomSnackbarTop.setBackgroundResource(R.drawable.bg_light_red_border_red)
//                val tintColor = ContextCompat.getColor(context, R.color.red)
//                binding.ivStatus.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.btnClose.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
//                binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.red))
//            }
//        }
//
//
//
//        binding.btnClose.setOnClickListener {
//            snackbar.dismiss()
//        }
//
//        binding.clCustomSnackbarTop.setOnClickListener {
////            val bundle = Bundle().apply {
////                putInt(Args.EXTRA_PARAM_INT_ONE, 1)
////            }
////            navController.navigate(R.id.fragment_portofolio, bundle)
//
//            MainActivity.startIntentParam(activity, NavKeys.KEY_FM_TAB_PORTFOLIO, 1,"")
//            snackbar.dismiss()
//        }
//
//        snackbar.view.setBackgroundResource(R.color.transparent)
//
//        val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout
//        snackbarLayout.addView(binding.root, 0)
//        snackbar.show()
//    }
//
//    override fun showSnackBarOrder(
//        context: Context,
//        component: View,
//        buySell: String,
//        stockCode: String,
//        status: String,
//        lotSize: String,
//        price: Double
//    ) {
//        val binding = CustomSnackbarOrderBinding.inflate(LayoutInflater.from(context))
//        val snackbar = Snackbar.make(component, "", Snackbar.LENGTH_LONG)
//
//        // Set SnackBar From Top Of The Screen
//        if (snackbar.view.layoutParams is FrameLayout.LayoutParams) {
//            val params = snackbar.view.layoutParams as FrameLayout.LayoutParams
//            params.gravity = Gravity.BOTTOM
//            snackbar.view.layoutParams = params
//        } else if (snackbar.view.layoutParams is CoordinatorLayout.LayoutParams) {
//            val params = snackbar.view.layoutParams as CoordinatorLayout.LayoutParams
//            params.gravity = Gravity.BOTTOM
//            snackbar.view.layoutParams = params
//        }
//
//        val bs = if (buySell == "B") "Buy" else "Sell"
//
//        binding.tvNotif1.text = "$bs $stockCode - ${status.GET_STATUS_ORDER()}"
//        binding.tvNotif2.text = "$lotSize (lot) Rp $price"
//
//        val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout
//        snackbarLayout.addView(binding.root, 0)
//        snackbar.show()
//    }
}