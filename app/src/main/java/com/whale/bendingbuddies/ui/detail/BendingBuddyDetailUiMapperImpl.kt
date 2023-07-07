package com.whale.bendingbuddies.ui.detail

import com.whale.bendingbuddies.data.mapper.BendingBuddyMapper
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import javax.inject.Inject

class BendingBuddyDetailUiMapperImpl @Inject constructor() :
    BendingBuddyMapper<BendingBuddyEntity, DetailUiData> {

    override fun map(input: BendingBuddyEntity?): DetailUiData {

        return input?.let {
            DetailUiData(
                name = it.name,
                affiliation = it.affiliation,
                imageUrl = it.imageUrl
            )
        } ?: DetailUiData(null, null, null)
    }

}