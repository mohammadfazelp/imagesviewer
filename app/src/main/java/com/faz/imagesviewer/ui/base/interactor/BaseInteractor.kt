package com.faz.imagesviewer.ui.base.interactor

import com.faz.imagesviewer.data.network.IApiHelper
import com.faz.imagesviewer.data.preferences.IPreferenceHelper
import com.faz.imagesviewer.utils.AppConstants

open class BaseInteractor() : IInteractor {

    protected lateinit var preferenceHelper: IPreferenceHelper
    protected lateinit var apiHelper: IApiHelper

    constructor(preferenceHelper: IPreferenceHelper, apiHelper: IApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

    override fun isUserLoggedIn() = this.preferenceHelper.getCurrentUserLoggedInMode() !=
            AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type

    override fun performUserLogout() = preferenceHelper.let {
        it.setCurrentUserId(null)
        it.setAccessToken(null)
        it.setCurrentUserEmail(null)
        it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }

}