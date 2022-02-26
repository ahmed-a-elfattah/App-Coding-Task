package com.aelfattah.ahmed.appcodingtask.data.sources.remote

import com.aelfattah.ahmed.appcodingtask.data.models.File
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface FileApi {

    @GET("movies")
    fun getListOfFileResponse(): Single<List<File>>
}