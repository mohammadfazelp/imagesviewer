package com.faz.imagesviewer.di.builder

import com.faz.imagesviewer.ui.home.HomeActivityModule
import com.faz.imagesviewer.ui.home.view.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity
}