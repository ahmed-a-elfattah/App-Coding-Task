package com.aelfattah.ahmed.appcodingtask.data.sources.remote

import com.aelfattah.ahmed.appcodingtask.data.models.Movie
import io.reactivex.Observable
import retrofit2.http.GET

interface MoviesApi {

    @GET("movies")
    fun getListOfFileResponse(): Observable<List<Movie>>
}