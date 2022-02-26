package com.aelfattah.ahmed.appcodingtask.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aelfattah.ahmed.appcodingtask.data.models.File
import com.aelfattah.ahmed.appcodingtask.databinding.ItemFileResponseBinding

class FileResponseAdapter constructor(private val listener: FileResponseListener) :
    RecyclerView.Adapter<FileResponseAdapter.FileResponseViewHolder>() {
    private var list: ArrayList<File> = ArrayList()

    inner class FileResponseViewHolder(val binding: ItemFileResponseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.ivDownloadFile.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    listener.onFileDownloadClicked(list[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileResponseViewHolder =
        FileResponseViewHolder(
            ItemFileResponseBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    override fun onBindViewHolder(holder: FileResponseViewHolder, position: Int) {
        val file =  java.io.File(holder.binding.root.context.cacheDir, list[position].name)
        list[position].isDownloaded = file.exists()
        holder.binding.file = list[position]
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<File>) {
        this.list=list
        notifyDataSetChanged()
//        val diffCallback = FileResponseDiffCallback(this.list, list)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
//        this.list.clear()
//        this.list.addAll(list)
//        diffResult.dispatchUpdatesTo(this)
    }

    interface FileResponseListener {
        fun onFileDownloadClicked(file: File)
    }
}