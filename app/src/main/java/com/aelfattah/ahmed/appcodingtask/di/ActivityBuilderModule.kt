package com.aelfattah.ahmed.appcodingtask.di

import com.aelfattah.ahmed.appcodingtask.di.main.MainViewModelModule
import com.aelfattah.ahmed.appcodingtask.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainViewModelModule::class])
    abstract fun contributeMainActivity(): MainActivity
}