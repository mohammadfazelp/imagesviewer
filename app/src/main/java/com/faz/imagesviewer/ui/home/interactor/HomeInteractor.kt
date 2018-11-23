package com.faz.imagesviewer.ui.home.interactor

import com.faz.imagesviewer.data.network.IApiHelper
import com.faz.imagesviewer.data.network.LoginRequest
import com.faz.imagesviewer.data.network.LoginResponse
import com.faz.imagesviewer.data.preferences.IPreferenceHelper
import com.faz.imagesviewer.ui.base.interactor.BaseInteractor
import com.faz.imagesviewer.utils.AppConstants
import javax.inject.Inject

class HomeInteractor @Inject internal constructor(preferenceHelper: IPreferenceHelper,
                                                  apiHelper: IApiHelper) :
        BaseInteractor(preferenceHelper, apiHelper), IHomeMvpInteractor {


    override fun doServerLoginApiCall(email: String, password: String) =
            apiHelper.performServerLogin(LoginRequest.ServerLoginRequest(email = email,
                    password = password))


    override fun updateUserInSharedPref(loginResponse: LoginResponse,
                                        loggedInMode: AppConstants.LoggedInMode) =
            preferenceHelper.let {
                it.setCurrentUserId(loginResponse.userId)
                it.setAccessToken(loginResponse.accessToken)
                it.setCurrentUserLoggedInMode(loggedInMode)
            }
}