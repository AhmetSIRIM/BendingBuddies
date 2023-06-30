package com.whale.bendingbuddies.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseViewHolder<T : Any>(view: View) : ViewHolder(view) {

    abstract fun onBind(data: T)

}
