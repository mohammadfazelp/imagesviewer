package com.faz.imagesviewer.data.database.repository.images

import io.reactivex.Observable
import javax.inject.Inject

class ImageRepository @Inject internal constructor(private val imagesDao: ImagesDao) : ImagesRepo {

    override fun isImagesRepoEmpty(): Observable<Boolean> = Observable.fromCallable({ imagesDao.loadAll().isEmpty() })

    override fun insertImages(images: List<Image>): Observable<Boolean> {
        imagesDao.insertAll(images)
        return Observable.just(true)
    }

    override fun loadImages(): Observable<List<Image>> = Observable.fromCallable({ imagesDao.loadAll() })
}


