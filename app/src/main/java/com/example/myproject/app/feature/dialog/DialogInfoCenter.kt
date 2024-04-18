package com.example.myproject.app.feature.dialog

import com.example.myproject.base.dialog.withoutvm.BaseDialogFragment
import com.example.myproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import id.co.kalacakra.bcas.ext.activity.autoCleaned

@FragmentScoped
@AndroidEntryPoint
class DialogInfoCenter(
//    private val uiDialogModel: UIDialogModel
) : BaseDialogFragment<ActivityMainBinding>() {

//    private var okButtonClickListener: ((Boolean) -> Unit)? = null

    @FragmentScoped
    override val binding: ActivityMainBinding by autoCleaned { (ActivityMainBinding.inflate(layoutInflater)) }


//    override fun setupComponent() {
//        super.setupComponent()
//
//        // if title is not null use it, when null use titleStr. when null again the default is ""
//        binding.title.text = uiDialogModel.title?.let { getString(it) } ?: uiDialogModel.titleStr ?: ""
//        binding.description.text = uiDialogModel.description?.let { getString(it) } ?: uiDialogModel.descriptionStr ?: ""
//        binding.buttonOk.text = uiDialogModel.btnPositive?.let { getString(it) }
//    }
//
//    override fun initOnClick() {
//        super.initOnClick()
//
//        binding.buttonClose.setOnClickListener {
//            dismiss()
//        }
//
//        binding.buttonOk.setOnClickListener {
////            if (!reqTargetCode.isNullOrBlank() && !reqTargetCode.isNullOrEmpty()) {
//////                sendCallback()
////            }
//            okButtonClickListener?.invoke(true)
//            dismiss()
//        }
//    }
//
//    fun setOkButtonClickListener(listener: (Boolean) -> Unit) {
//        okButtonClickListener = listener
//    }
}