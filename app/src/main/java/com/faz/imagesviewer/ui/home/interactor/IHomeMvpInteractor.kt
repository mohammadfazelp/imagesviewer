package com.faz.imagesviewer.ui.home.interactor

import com.faz.imagesviewer.data.network.model.images.ImageResponse
import com.faz.imagesviewer.data.network.model.images.ImagesListResponse
import com.faz.imagesviewer.ui.base.interactor.IInteractor
import io.reactivex.Observable

interface IHomeMvpInteractor : IInteractor {

    fun doServerGetImagesApiCall():Observable<ArrayList<ImageResponse>>
}