package com.faz.imagesviewer.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.faz.imagesviewer.di.ApiKeyInfo
import com.faz.imagesviewer.di.PreferenceInfo
import com.faz.imagesviewer.utils.SchedulerProvider
import com.faz.imagesviewer.data.database.AppDatabase
import com.faz.imagesviewer.data.database.repository.images.ImageRepository
import com.faz.imagesviewer.data.database.repository.images.ImagesRepo
import com.faz.imagesviewer.data.preferences.PreferenceHelper
import com.faz.imagesviewer.data.preferences.IPreferenceHelper
import com.faz.imagesviewer.data.network.ApiHeader
import com.faz.imagesviewer.data.network.ApiHelper
import com.faz.imagesviewer.data.network.IApiHelper
import com.faz.imagesviewer.utils.AppConstants
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = "" /*AppConstants.API_KEY*/

    @Provides
    @PreferenceInfo
    internal fun providePrefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(preferenceHelper: PreferenceHelper): IPreferenceHelper
            = preferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: IPreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
            userId = preferenceHelper.getCurrentUserId(),
            accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(apiHelper: ApiHelper): IApiHelper = apiHelper

    @Provides
    @Singleton
    internal fun provideImageRepoHelper(appDatabase: AppDatabase): ImagesRepo =
            ImageRepository(appDatabase.imagesDao())


    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()
}