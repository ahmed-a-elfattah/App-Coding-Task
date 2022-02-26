package com.aelfattah.ahmed.appcodingtask.data.repositories

import com.aelfattah.ahmed.appcodingtask.data.models.File
import io.reactivex.Single

interface FileRepository {
    fun getListOfFileResponse(): Single<List<File>>
}