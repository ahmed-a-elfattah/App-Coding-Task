package com.aelfattah.ahmed.appcodingtask.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aelfattah.ahmed.appcodingtask.data.models.File
import com.aelfattah.ahmed.appcodingtask.data.repositories.FileRepositoryImpl
import com.aelfattah.ahmed.appcodingtask.utils.FileDownloader
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val repositoryImpl: FileRepositoryImpl,
    private val fileDownloader: FileDownloader
) :
    ViewModel() {
    companion object {
        private const val TAG = "MainViewModel"
    }

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> get() = _progress

    val filesResponse = MutableLiveData<ArrayList<File>>()
    private lateinit var disposable: Disposable

    private val _downloadFinished: MutableLiveData<Boolean> = MutableLiveData(true)
    val downloadFinished: LiveData<Boolean> get() = _downloadFinished

    init {
        loadData()
    }

    private fun loadData() {
        _loading.value = true
        disposable = repositoryImpl.getListOfFileResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _loading.value = false
                    filesResponse.value = it as ArrayList<File>?
                },
                {
                    Log.e(TAG, "loadData: $it")
                    _loading.value = false
                    _errorMessage.value = it.message
                }
            )
    }

    fun downloadFile(fileDir: java.io.File, file: File) {
        _downloadFinished.value = false
        disposable = fileDownloader.download(file = fileDir, url = file.realUrl())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it is String)
                        _downloadFinished.value = true
                    else {
                        _progress.value = it as Int
                        _downloadFinished.value = false
                    }
                },
                {
                    _downloadFinished.value = true
                    _errorMessage.value = it.message
                }
            )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}