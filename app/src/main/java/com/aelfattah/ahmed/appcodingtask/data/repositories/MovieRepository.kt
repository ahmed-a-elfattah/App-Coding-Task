package com.aelfattah.ahmed.appcodingtask.data.repositories

import com.aelfattah.ahmed.appcodingtask.data.models.Movie
import io.reactivex.Observable

interface MovieRepository {
    fun getListOfFileResponse(): Observable<List<Movie>>
}