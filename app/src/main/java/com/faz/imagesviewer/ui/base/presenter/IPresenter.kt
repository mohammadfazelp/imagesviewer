package com.faz.imagesviewer.ui.base.presenter

import com.faz.imagesviewer.ui.base.interactor.IInteractor
import com.faz.imagesviewer.ui.base.view.IBaseView

interface IPresenter<V : IBaseView, I : IInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}