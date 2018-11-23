package com.faz.imagesviewer.ui.home

import com.faz.imagesviewer.ui.home.interactor.HomeInteractor
import com.faz.imagesviewer.ui.home.interactor.IHomeMvpInteractor
import com.faz.imagesviewer.ui.home.presenter.IHomeMvpPresenter
import com.faz.imagesviewer.ui.home.presenter.HomePresenter
import com.faz.imagesviewer.ui.home.view.HomeView
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    internal fun provideHomeInteractor(interactor: HomeInteractor): IHomeMvpInteractor = interactor

    @Provides
    internal fun provideHomePresenter(presenter: HomePresenter<HomeView, IHomeMvpInteractor>)
            : IHomeMvpPresenter<HomeView, IHomeMvpInteractor> = presenter
}