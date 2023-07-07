package com.whale.bendingbuddies.ui.home

import android.view.ViewGroup
import com.whale.bendingbuddies.databinding.AdapterBendingBuddyItemBinding
import com.whale.bendingbuddies.ui.base.BaseViewHolder
import com.whale.bendingbuddies.utility.inflateAdapterItem

class BendingBuddyViewHolder(
    private val binding: AdapterBendingBuddyItemBinding
) : BaseViewHolder<HomeUiData>(binding.root) {

    companion object {
        fun createFrom(parent: ViewGroup): BendingBuddyViewHolder {
            return BendingBuddyViewHolder(parent.inflateAdapterItem(AdapterBendingBuddyItemBinding::inflate))
        }
    }

    override fun onBind(viewHolderData: HomeUiData) {
        binding.bendingBuddyComponent.setBendingBuddyHomeData(viewHolderData)
    }

}