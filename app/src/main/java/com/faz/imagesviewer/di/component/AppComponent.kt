package com.faz.imagesviewer.di.component

import android.app.Application
import com.faz.imagesviewer.App
import com.faz.imagesviewer.di.builder.ActivityBuilder
import com.faz.imagesviewer.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}