package com.faz.imagesviewer.data.network

import com.faz.imagesviewer.data.network.model.images.ImageResponse
import io.reactivex.Observable

interface IApiHelper {

    fun getImagesFromServer(): Observable<MutableList<ImageResponse>>?
}