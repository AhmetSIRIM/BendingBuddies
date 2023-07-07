package com.whale.bendingbuddies.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.whale.bendingbuddies.databinding.LayoutBendingBuddyBinding
import com.whale.bendingbuddies.ui.detail.DetailUiData
import com.whale.bendingbuddies.ui.home.HomeUiData
import com.whale.bendingbuddies.utility.loadImage

class BendingBuddyComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding =
        LayoutBendingBuddyBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setBendingBuddyHomeData(homeUiData: HomeUiData) {
        binding.apply {
            bendingBuddyName.text = homeUiData.name
            bendingBuddyImage.loadImage(homeUiData.imageUrl)
        }
    }

    fun setBendingBuddyDetailData(detailUiData: DetailUiData) {
        binding.apply {
            bendingBuddyName.text = detailUiData.name
            bendingBuddyName.text = detailUiData.affiliation
            detailUiData.imageUrl?.let { bendingBuddyImage.loadImage(it) }
        }
    }

}