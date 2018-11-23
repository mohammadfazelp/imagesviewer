package com.faz.imagesviewer.ui.base.view

import android.os.Bundle
import android.view.View

interface IBaseView : View.OnClickListener {

    fun initData(bundle: Bundle?)

    fun bindLayout(): Int?

    fun initView(savedInstanceState: Bundle, contentView: View)

    fun processLogic()
}