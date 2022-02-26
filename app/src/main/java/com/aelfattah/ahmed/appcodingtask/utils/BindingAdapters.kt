package com.aelfattah.ahmed.appcodingtask.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.aelfattah.ahmed.appcodingtask.R

object BindingAdapters {

    @BindingAdapter("app:type")
    @JvmStatic
    fun bindType(imageView: ImageView, type: String) {
        when (type) {
            "PDF" -> {
                imageView.setImageResource(R.drawable.ic_pdf)
            }
            "VIDEO" -> {
                imageView.setImageResource(R.drawable.ic_video)
            }
        }
    }

    @BindingAdapter("app:downloaded")
    @JvmStatic
    fun bindDownloaded(imageView: ImageView, isDownloaded: Boolean) {
        when (isDownloaded) {
            true -> {
                imageView.setImageResource(R.drawable.ic_cloud_done_green_26dp)
            }
            false -> {
                imageView.setImageResource(R.drawable.ic_cloud_download_gray_26dp)
            }
        }
    }
}