package com.faz.imagesviewer.data.network

import com.faz.imagesviewer.data.network.model.images.ImageResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiHeader: ApiHeader) : IApiHelper {


    override fun getImagesFromServer(): Observable<MutableList<ImageResponse>>? =
            Rx2AndroidNetworking.get(ApiEndPoint.BASE_URL)
                    //.addHeaders(apiHeader.publicApiHeader)
                    .build()
                    .getObjectListObservable(ImageResponse::class.java)
}