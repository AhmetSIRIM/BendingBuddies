package com.bendingbuddies.feature.home

import com.bendingbuddies.core.presentation.base.BaseViewHolder
import com.bendingbuddies.core.presentation.model.home.HomeUiData
import com.bendingbuddies.feature.home.databinding.AdapterBendingBuddyItemBinding

class BendingBuddyViewHolder(
    private val binding: AdapterBendingBuddyItemBinding,
    onItemClickListener: ((Int) -> Unit)?
) : BaseViewHolder<HomeUiData>(binding.root) {

    init {
        binding.root.setOnClickListener {
            onItemClickListener?.invoke(adapterPosition)
        }
    }

    override fun onBind(viewHolderData: HomeUiData) {
        binding.bendingBuddyComponent.setBendingBuddyHomeData(viewHolderData)
    }

}