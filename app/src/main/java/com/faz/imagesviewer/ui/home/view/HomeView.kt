package com.faz.imagesviewer.ui.home.view

import com.faz.imagesviewer.data.network.model.images.ImageResponse
import com.faz.imagesviewer.ui.base.view.IBaseMvp

interface HomeView : IBaseMvp {

    fun addData(images: ArrayList<ImageResponse>)

    fun showError(err: Throwable)
}