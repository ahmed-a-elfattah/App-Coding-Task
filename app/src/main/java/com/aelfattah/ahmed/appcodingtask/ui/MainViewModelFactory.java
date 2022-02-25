package com.aelfattah.ahmed.appcodingtask.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.aelfattah.ahmed.appcodingtask.data.repositories.MovieRepositoryImpl;

import javax.inject.Inject;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    MovieRepositoryImpl repositoryImpl;

    public MainViewModelFactory(MovieRepositoryImpl repositoryImpl) {
        this.repositoryImpl = repositoryImpl;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repositoryImpl);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
