package com.faz.imagesviewer.ui.home.interactor

import com.faz.imagesviewer.data.network.LoginResponse
import com.faz.imagesviewer.ui.base.interactor.IInteractor
import com.faz.imagesviewer.utils.AppConstants
import io.reactivex.Observable

interface IHomeMvpInteractor : IInteractor {

    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)
}