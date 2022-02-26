package com.aelfattah.ahmed.appcodingtask.utils

import android.util.Log
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.net.HttpURLConnection
import javax.inject.Inject

class FileDownloader @Inject constructor(private val okHttpClient: OkHttpClient) {
    companion object {
        private const val TAG = "FileDownloader"
        private const val BUFFER_LENGTH_BYTES = 1024 * 8
    }

    fun download(url: String, file: File): Observable<Any> {
        return Observable.create {
            val request = Request.Builder().url(url).build()
            val response = okHttpClient.newCall(request).execute()
            val body = response.body
            val responseCode = response.code
            if (responseCode >= HttpURLConnection.HTTP_OK &&
                responseCode < HttpURLConnection.HTTP_MULT_CHOICE &&
                body != null
            ) {
                val length = body.contentLength()
                body.byteStream().apply {
                    file.outputStream().use { fileOut ->
                        var bytesDownloaded: Long = 0
                        val buffer = ByteArray(BUFFER_LENGTH_BYTES)
                        var bytes = read(buffer)
                        while (bytes >= 0) {
                            fileOut.write(buffer, 0, bytes)
                            bytesDownloaded += bytes
                            bytes = read(buffer)
                            Log.e(TAG, "bytesDownloaded: $bytesDownloaded $length")
                            if (bytesDownloaded < length) {
                                it.onNext((((bytesDownloaded * 100L) / length).toInt()))
                            } else {
                                it.onNext(("finished"))
                            }
                        }
                    }
                }
            } else {
                it.onError(IllegalArgumentException("Error occurred when do http get $url"))
            }
        }
    }
}