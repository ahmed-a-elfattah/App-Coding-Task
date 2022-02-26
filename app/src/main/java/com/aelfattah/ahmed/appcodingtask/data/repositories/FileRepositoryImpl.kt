package com.aelfattah.ahmed.appcodingtask.data.repositories

import com.aelfattah.ahmed.appcodingtask.data.models.File
import com.aelfattah.ahmed.appcodingtask.data.sources.remote.FileApi
import io.reactivex.Single
import javax.inject.Inject

class FileRepositoryImpl @Inject constructor(private val fileApi: FileApi) : FileRepository {
    override fun getListOfFileResponse(): Single<List<File>> =
        fileApi.getListOfFileResponse()
}