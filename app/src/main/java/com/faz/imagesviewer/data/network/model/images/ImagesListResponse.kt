package com.faz.imagesviewer.data.network.model.images

import com.google.gson.annotations.Expose

data class ImagesListResponse(@Expose var images: List<ImageResponse>? = null)