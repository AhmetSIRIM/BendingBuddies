package com.bendingbuddies.feature.detail

import com.bendingbuddies.core.common.mapper.BendingBuddyMapper
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import com.bendingbuddies.core.presentation.model.detail.DetailUiData
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