package com.faz.imagesviewer.data.network

import io.reactivex.Observable

interface IApiHelper {

    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>
}