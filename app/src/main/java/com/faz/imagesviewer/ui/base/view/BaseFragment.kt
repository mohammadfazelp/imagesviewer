package com.faz.imagesviewer.ui.base.view

import androidx.annotation.IdRes
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.view.View
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.faz.imagesviewer.utils.CommonUtils
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment : Fragment(), IBaseView ,IBaseMvp{

    protected var mContentView: View? = null
    protected var mActivity: Activity?=null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        setHasOptionsMenu(false)
        if (savedInstanceState != null) {
            val isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN)
            val ft = fragmentManager?.beginTransaction()
            if (isSupportHidden) {
                ft?.hide(this)
            } else {
                ft?.show(this)
            }
            ft?.commitAllowingStateLoss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: ")
        bindLayout()?.let { setRootLayout(it) }
        return mContentView
    }

    protected fun setRootLayout(layoutId: Int) {
        if (layoutId <= 0) return
        mContentView = mActivity?.layoutInflater?.inflate(layoutId, null)
    }


    override fun onActivityCreated(@Nullable savedInstanceState: Bundle ?) {
        Log.d(TAG, "onActivityCreated: ")
        super.onActivityCreated(savedInstanceState)
        mActivity = activity
        savedInstanceState?.let { initView(it, mContentView!!) }
        processLogic()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView: ")
        if (mContentView != null) {
            (mContentView?.parent as ViewGroup).removeView(mContentView)
        }
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onSaveInstanceState(@NonNull outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: ")
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
    }

    fun <T : View> findViewById(@IdRes id: Int): T {
        if (mContentView == null) throw NullPointerException("ContentView is null.")
        return mContentView!!.findViewById(id)
    }

    companion object {
        private const val TAG = "BaseFragment"
        private const val STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN"
    }

    private var parentActivity: BaseActivity? = null
    private var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        initData(bundle)
    }

    override fun hideProgress() {
        if (progressDialog != null && progressDialog?.isShowing!!) {
            progressDialog?.cancel()
        }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this.context)
    }

    fun getBaseActivity() = parentActivity

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }
}