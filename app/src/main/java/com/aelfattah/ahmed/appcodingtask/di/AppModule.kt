package com.aelfattah.ahmed.appcodingtask.di

import com.aelfattah.ahmed.appcodingtask.data.sources.remote.EndPoints
import com.aelfattah.ahmed.appcodingtask.data.sources.remote.FileApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun providesFileApi(retrofit: Retrofit): FileApi = retrofit.create(FileApi::class.java)

}