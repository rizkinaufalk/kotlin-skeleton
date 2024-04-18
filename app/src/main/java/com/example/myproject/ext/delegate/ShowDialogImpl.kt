package com.example.myproject.ext.delegate


//var dialogInfoCenter: DialogInfoCenter? = null
//var dialogInfoBottom: DialogInfoBottom? = null
//var dialogSelectionBottom: DialogSelectionBottom? = null

interface ShowDialog {

//    fun showDialogInfoCenter(
//        isCancelable: Boolean,
//        uiDialogModel: UIDialogModel,
//        fragmentManager: FragmentManager,
//    )
//
//    fun showDialogInfoCenterCallBack(
//        isCancelable: Boolean, fragmentManager: FragmentManager,
//        uiDialogModel: UIDialogModel, onOkClicked: ((Boolean) -> Unit)?,
//    )
//
//    fun showDialogInfoBottom(
//        isCancelable: Boolean,
//        uiDialogModel: UIDialogModel,
//        fragmentManager: FragmentManager,
//    )

}

/** Dialog Info */

class ShowDialogImpl : ShowDialog {
//    override fun showDialogInfoCenter(
//        isCancelable: Boolean,
//        uiDialogModel: UIDialogModel, fragmentManager: FragmentManager,
//    ) {
//        if (dialogInfoCenter == null) {
//            dialogInfoCenter = DialogInfoCenter(uiDialogModel)
//            dialogInfoCenter?.dialog?.setOnDismissListener {
//                // This code will be executed when the dialog is dismissed
//                dialogInfoCenter = null
//            }
//            dialogInfoCenter?.isCancelable = isCancelable
//            dialogInfoCenter?.show(fragmentManager, null)
//        }
//    }
//
//    override fun showDialogInfoCenterCallBack(
//        isCancelable: Boolean,
//        fragmentManager: FragmentManager,
//        uiDialogModel: UIDialogModel,
//        onOkClicked: ((Boolean) -> Unit)?,
//    ) {
//        if (dialogInfoCenter == null) {
//            dialogInfoCenter = DialogInfoCenter(uiDialogModel)
//
//            dialogInfoCenter?.setOkButtonClickListener { category ->
//                onOkClicked?.invoke(category)
//                dialogInfoCenter = null
//            }
//
//            dialogInfoCenter?.setOnDialogDismissListener(object : OnDialogDismissListener {
//                override fun onDialogCanceled() {
//                    dialogInfoCenter = null
//                }
//
//                override fun onDialogDismissed() {
//                    dialogInfoCenter = null
//                }
//            })
//
//            dialogInfoCenter?.isCancelable = isCancelable
//            dialogInfoCenter?.show(fragmentManager, null)
//        }
//    }
//
//    override fun showDialogInfoBottom(
//        isCancelable: Boolean,
//        uiDialogModel: UIDialogModel,
//        fragmentManager: FragmentManager,
//    ) {
//        if (dialogInfoBottom == null) {
//            dialogInfoBottom = DialogInfoBottom(null, uiDialogModel)
//            dialogInfoBottom?.setOnDialogDismissListener(object : OnDialogDismissListener {
//                override fun onDialogCanceled() {
//                    dialogInfoBottom = null
//                }
//
//                override fun onDialogDismissed() {
//                    dialogInfoBottom = null
//                }
//            })
//            dialogInfoBottom?.isCancelable = isCancelable
//
//            dialogInfoBottom?.show(fragmentManager, null)
//        }
//    }


}