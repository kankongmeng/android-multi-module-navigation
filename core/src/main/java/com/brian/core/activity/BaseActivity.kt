package com.brian.core.activity

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.brian.core.R
import com.brian.core.viewmodel.BaseViewModel

abstract class BaseActivity<vm : BaseViewModel?> : AppCompatActivity() {
    protected abstract val viewModel: vm

    private var commonPbDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Observe showRefreshing value to display or hide progressBar
        viewModel?.showRefreshing?.observe(this, Observer { showLoading ->
            showCommonLoadingDialog(showLoading)
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun showCommonLoadingDialog(isShow: Boolean? = true) {
        if (isShow == true && commonPbDialog?.isShowing != true) commonPbDialog = showLoader()
        else if (isShow == false && commonPbDialog?.isShowing == true) commonPbDialog?.dismiss()
    }

    private fun showLoader(): Dialog {
        val dialog = Dialog(this)

        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(false)
            setContentView(R.layout.core_common_progressbar)
            window?.let {
                it.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                it.setDimAmount(0.5F)
            }
        }.show()

        return dialog
    }
}
