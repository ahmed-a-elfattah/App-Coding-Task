package com.aelfattah.ahmed.appcodingtask

import com.aelfattah.ahmed.appcodingtask.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this)
            .context(this)
            .build()
    }
}