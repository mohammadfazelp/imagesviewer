package com.faz.imagesviewer.data.network

import androidx.databinding.ObservableArrayList
import com.faz.imagesviewer.data.network.model.images.ImageResponse
import com.faz.imagesviewer.data.network.model.images.ImagesListResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiHeader: ApiHeader) : IApiHelper {

    /*override fun getImagesFromServer(): Observable<ImagesListResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.BASE_URL)
                //.addHeaders(apiHeader.publicApiHeader)
                .build()
                .getObjectObservable(ImagesListResponse::class.java)*/

    override fun getImagesFromServer(): Observable<ArrayList<ImageResponse>> =
            Rx2AndroidNetworking.get(ApiEndPoint.BASE_URL)
                    //.addHeaders(apiHeader.publicApiHeader)
                    .build()
                    .getObjectObservable(arrayOf(ObservableArrayListArrayList)
                    <ImageResponse>::class.java)
}