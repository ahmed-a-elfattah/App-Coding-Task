package com.aelfattah.ahmed.appcodingtask.utils

import io.reactivex.Single
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object NetworkUtils {

    fun hasInternetConnection(): Single<Boolean> = Single.create {
        try {
            // Connect to Google DNS to check for connection
            val timeoutMs = 1500
            val socket = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53)
            socket.connect(socketAddress, timeoutMs)
            socket.close()
            it.onSuccess(true)
        } catch (e: IOException) {
            it.onSuccess(false)
        }
    }

}