package com.faz.imagesviewer.ui.home.presenter

import com.faz.imagesviewer.ui.base.presenter.IPresenter
import com.faz.imagesviewer.ui.home.interactor.IHomeMvpInteractor
import com.faz.imagesviewer.ui.home.view.HomeView

interface IHomeMvpPresenter<V : HomeView, I : IHomeMvpInteractor> : IPresenter<V, I> {

    //fun onServerLoginClicked(email: String, password: String)

    fun onServerGetImages()
}
