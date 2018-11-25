package com.faz.imagesviewer.data.database.repository.images

import io.reactivex.Observable

interface ImagesRepo {

    fun isImagesRepoEmpty(): Observable<Boolean>

    fun insertImages(images: List<Image>): Observable<Boolean>

    fun loadImages(): Observable<List<Image>>
}