package com.faz.imagesviewer.ui.base.presenter

import com.faz.imagesviewer.ui.base.interactor.IInteractor
import com.faz.imagesviewer.ui.base.view.IBaseMvp

interface IPresenter<V : IBaseMvp, I : IInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}