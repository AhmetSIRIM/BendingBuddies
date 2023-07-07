package com.whale.bendingbuddies.ui.home

import android.view.ViewGroup
import com.whale.bendingbuddies.ui.base.BaseRecyclerViewAdapter

class BendingBuddyRecyclerViewAdapter:
    BaseRecyclerViewAdapter<HomeUiData, BendingBuddyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BendingBuddyViewHolder {
        return BendingBuddyViewHolder.createFrom(parent)
    }

}