package com.faz.imagesviewer

import android.app.Activity
import android.content.Context
import com.faz.imagesviewer.di.component.DaggerAppComponent
import com.faz.imagesviewer.ui.base.BaseApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : BaseApp() , HasActivityInjector {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    var mInstance: App? = null

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    companion object {
        fun getInstance() : App? = App().mInstance
    }
}
