package com.bendingbuddies.core.presentation.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseViewHolder<T : Any>(view: View) : ViewHolder(view) {

    abstract fun onBind(viewHolderData: T)

}
