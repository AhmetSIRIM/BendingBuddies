package com.whale.bendingbuddies.ui.home

import com.whale.bendingbuddies.databinding.AdapterBendingBuddyItemBinding
import com.whale.bendingbuddies.ui.base.BaseViewHolder

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