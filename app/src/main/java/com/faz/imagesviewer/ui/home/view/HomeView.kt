package com.faz.imagesviewer.ui.home.view

import com.faz.imagesviewer.ui.base.view.IBaseView

interface HomeView : IBaseView {
    fun showValidationMessage(errorCode: Int)
}