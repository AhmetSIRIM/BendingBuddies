package com.whale.bendingbuddies.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : Any, ViewHolder : BaseViewHolder<T>> :
    RecyclerView.Adapter<ViewHolder>() {

    private val items = mutableListOf<T>()

    fun updateHomeUiDataList(newItems: List<T>) {
        items.apply {
            clear()
            addAll(newItems)
            notifyDataSetChanged()
        }
    }

    fun getItem(position: Int) = items[position]

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

}