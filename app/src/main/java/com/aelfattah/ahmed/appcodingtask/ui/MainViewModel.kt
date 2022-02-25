package com.aelfattah.ahmed.appcodingtask.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.aelfattah.ahmed.appcodingtask.data.repositories.MovieRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(private val repositoryImpl: MovieRepositoryImpl) :
    ViewModel() {
    companion object{
        private const val TAG = "MainViewModel"
    }

    init {

    }
    fun loadData(){
        repositoryImpl.getListOfFileResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.e(TAG, "list: $it" )
            }
    }
}