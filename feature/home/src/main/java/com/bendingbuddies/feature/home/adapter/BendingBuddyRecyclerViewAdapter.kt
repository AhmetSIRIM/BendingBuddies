package com.bendingbuddies.feature.home.adapter

import android.view.ViewGroup
import com.bendingbuddies.core.presentation.base.BaseRecyclerViewAdapter
import com.bendingbuddies.core.presentation.model.home.HomeUiData
import com.bendingbuddies.core.presentation.utility.inflateAdapterItem
import com.bendingbuddies.feature.home.BendingBuddyViewHolder
import com.bendingbuddies.feature.home.databinding.AdapterBendingBuddyItemBinding

class BendingBuddyRecyclerViewAdapter :
    BaseRecyclerViewAdapter<HomeUiData, BendingBuddyViewHolder>() {

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((Int) -> Unit)?) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BendingBuddyViewHolder {
        return BendingBuddyViewHolder(
            parent.inflateAdapterItem(AdapterBendingBuddyItemBinding::inflate),
            onItemClickListener
        )
    }

}