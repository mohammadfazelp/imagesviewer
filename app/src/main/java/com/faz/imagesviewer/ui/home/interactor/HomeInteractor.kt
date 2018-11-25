package com.faz.imagesviewer.ui.home.interactor

import com.faz.imagesviewer.data.network.IApiHelper
import com.faz.imagesviewer.data.network.model.images.ImageResponse
import com.faz.imagesviewer.data.network.model.images.ImagesListResponse
import com.faz.imagesviewer.data.preferences.IPreferenceHelper
import com.faz.imagesviewer.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class HomeInteractor @Inject internal constructor(preferenceHelper: IPreferenceHelper,
                                                  apiHelper: IApiHelper) :
        BaseInteractor(preferenceHelper, apiHelper), IHomeMvpInteractor {

    override fun doServerGetImagesApiCall(): Observable<ArrayList<ImageResponse>> =
            apiHelper.getImagesFromServer()
}