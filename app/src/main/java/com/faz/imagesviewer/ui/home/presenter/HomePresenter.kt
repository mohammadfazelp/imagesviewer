package com.faz.imagesviewer.ui.home.presenter

import com.faz.imagesviewer.data.network.model.images.ImageResponse
import com.faz.imagesviewer.ui.base.presenter.BasePresenter
import com.faz.imagesviewer.ui.home.interactor.IHomeMvpInteractor
import com.faz.imagesviewer.ui.home.view.HomeView
import com.faz.imagesviewer.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class HomePresenter<V : HomeView, I : IHomeMvpInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider,
                             disposable: CompositeDisposable) : BasePresenter<V, I>
(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        IHomeMvpPresenter<V, I> {

    override fun onServerGetImages() {
        //interactor?.doServerGetImagesApiCall()
        getView()?.showProgress()
        interactor?.let {
            it.doServerGetImagesApiCall()?.compose(
                    schedulerProvider.ioToMainObservableScheduler())?.subscribe({ response ->
                getView()?.addData(response as ArrayList<ImageResponse>)
                getView()?.hideProgress()
            }, { err -> println(err)
                getView()?.showError(err)
                getView()?.hideProgress()})?.let { it1 -> compositeDisposable.add(it1) }
        }
    }

    /*override fun onServerLoginClicked(email: String, password: String) {
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: AppConstants.LoggedInMode) =
            interactor?.updateUserInSharedPref(loginResponse, loggedInMode)*/
}
