package com.bendingbuddies.core.presentation.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bendingbuddies.core.presentation.databinding.LayoutBendingBuddyBinding
import com.bendingbuddies.core.presentation.model.detail.DetailUiData
import com.bendingbuddies.core.presentation.model.home.HomeUiData
import com.bendingbuddies.core.presentation.utility.loadImage

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
            bendingBuddyAffiliation.text = detailUiData.affiliation
            detailUiData.imageUrl?.let { bendingBuddyImage.loadImage(it) }
        }
    }

    fun setNameTextSize(value: Float) {
        binding.bendingBuddyName.setTextSize(TypedValue.COMPLEX_UNIT_SP, value)
    }

    fun setAffiliationTextSize(value: Float) {
        binding.bendingBuddyAffiliation.setTextSize(TypedValue.COMPLEX_UNIT_SP, value)
    }

}