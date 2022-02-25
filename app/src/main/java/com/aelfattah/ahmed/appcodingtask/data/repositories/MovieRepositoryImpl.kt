package com.aelfattah.ahmed.appcodingtask.data.repositories

import com.aelfattah.ahmed.appcodingtask.data.models.Movie
import com.aelfattah.ahmed.appcodingtask.data.sources.remote.MoviesApi
import io.reactivex.Observable
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val moviesApi: MoviesApi) : MovieRepository {
    override fun getListOfFileResponse(): Observable<List<Movie>> =
        moviesApi.getListOfFileResponse()
}