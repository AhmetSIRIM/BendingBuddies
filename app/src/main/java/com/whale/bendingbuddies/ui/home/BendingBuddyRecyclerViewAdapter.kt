package com.whale.bendingbuddies.ui.home

import android.view.ViewGroup
import com.whale.bendingbuddies.databinding.AdapterBendingBuddyItemBinding
import com.whale.bendingbuddies.ui.base.BaseRecyclerViewAdapter
import com.whale.bendingbuddies.utility.inflateAdapterItem

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