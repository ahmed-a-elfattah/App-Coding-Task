package com.aelfattah.ahmed.appcodingtask.di.main

import androidx.lifecycle.ViewModel
import com.aelfattah.ahmed.appcodingtask.di.viewModelsUtils.ViewModelKey
import com.aelfattah.ahmed.appcodingtask.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}