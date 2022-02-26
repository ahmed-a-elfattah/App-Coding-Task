package com.aelfattah.ahmed.appcodingtask.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.aelfattah.ahmed.appcodingtask.data.repositories.FileRepositoryImpl;
import com.aelfattah.ahmed.appcodingtask.utils.FileDownloader;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    FileRepositoryImpl repositoryImpl;
    FileDownloader fileDownloader;
    public MainViewModelFactory(FileRepositoryImpl repositoryImpl) {
        this.repositoryImpl = repositoryImpl;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repositoryImpl,fileDownloader);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
