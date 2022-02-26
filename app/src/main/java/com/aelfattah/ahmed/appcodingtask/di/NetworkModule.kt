package com.aelfattah.ahmed.appcodingtask.di

import android.content.Context
import com.aelfattah.ahmed.appcodingtask.data.sources.remote.EndPoints.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().serializeNulls().setLenient().create()
    }

    @Provides
    fun provideInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request().newBuilder()
            val actualRequest = request.build()
            it.proceed(actualRequest)
        }
    }

    @Provides
    fun provideOkHttpClient(
        appContext: Context,
        interceptor: Interceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(1000, TimeUnit.SECONDS)
            .readTimeout(1000, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
            .cache(Cache(appContext.cacheDir.absoluteFile, 1024 * 1024 * 30))//30Mb

        return httpBuilder
            .protocols(mutableListOf(Protocol.HTTP_1_1))
            .build()
    }

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
}