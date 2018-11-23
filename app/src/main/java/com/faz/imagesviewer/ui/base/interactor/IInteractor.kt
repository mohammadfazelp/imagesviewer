package com.faz.imagesviewer.ui.base.interactor

interface IInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()
}