package com.faz.imagesviewer.ui.base.view

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.faz.imagesviewer.utils.CommonUtils
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), IBaseView, IBaseMvp, BaseFragment.CallBack {

    lateinit var mContentView: View
    lateinit var mActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
        mActivity = this
        val bundle = intent.extras
        initData(bundle)
        bindLayout()?.let { setBaseView(it) }
        savedInstanceState?.let { initView(it, mContentView) }
        processLogic()
    }

    @SuppressLint("ResourceType")
    open fun setBaseView(@LayoutRes layoutId: Int) {
        if (layoutId <= 0) return
        mContentView = LayoutInflater.from(this).inflate(layoutId, null)
        setContentView(mContentView)
    }

    private var progressDialog: ProgressDialog? = null

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    private fun performDI() = AndroidInjection.inject(this)
}

