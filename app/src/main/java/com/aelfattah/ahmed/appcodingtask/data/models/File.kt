package com.aelfattah.ahmed.appcodingtask.data.models

import android.util.Patterns
import java.util.regex.Matcher

data class File(
    val id: Int,
    val name: String,
    val type: String,
    val url: String
){
    var isDownloaded: Boolean = false

    fun realUrl(): String {
        val m: Matcher = Patterns.WEB_URL.matcher(url)
        while (m.find()) {
            return m.group()
        }
        return url
    }
}