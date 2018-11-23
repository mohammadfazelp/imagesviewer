package com.faz.imagesviewer.ui.home.view

import android.os.Bundle
import android.view.View
import com.faz.imagesviewer.R
import com.faz.imagesviewer.ui.base.view.BaseActivity

class HomeActivity : BaseActivity() , HomeView {

    override fun showValidationMessage(errorCode: Int) {
    }

    override fun bindLayout(): Int {
        return R.layout.activity_home
    }

    override fun initView(savedInstanceState: Bundle, contentView: View) {
    }

    override fun processLogic() {
    }

    override fun onClick(p0: View?) {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onFragmentAttached() {
    }

    override fun initData(bundle: Bundle?) {
    }

}
