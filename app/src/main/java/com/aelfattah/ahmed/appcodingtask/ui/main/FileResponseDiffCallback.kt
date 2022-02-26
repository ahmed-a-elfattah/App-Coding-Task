package com.aelfattah.ahmed.appcodingtask.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.aelfattah.ahmed.appcodingtask.data.models.File

class FileResponseDiffCallback(
    private val oldList: ArrayList<File>,
    private val newList: ArrayList<File>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}