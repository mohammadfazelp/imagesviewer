package com.faz.imagesviewer.ui.base.presenter

import com.faz.imagesviewer.ui.base.interactor.IInteractor
import com.faz.imagesviewer.ui.base.view.IBaseView
import com.faz.imagesviewer.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : IBaseView, I : IInteractor> internal constructor(
        protected var interactor: I?, protected val schedulerProvider: SchedulerProvider,
        protected val compositeDisposable: CompositeDisposable) : IPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}