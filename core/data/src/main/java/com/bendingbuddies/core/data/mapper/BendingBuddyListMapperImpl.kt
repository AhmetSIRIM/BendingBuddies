package com.bendingbuddies.core.data.mapper

import com.bendingbuddies.core.common.mapper.BendingBuddyListMapper
import com.bendingbuddies.core.data.dto.BendingBuddyResponseItem
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import javax.inject.Inject

class BendingBuddyListMapperImpl @Inject constructor() :
    BendingBuddyListMapper<BendingBuddyResponseItem, BendingBuddyEntity> {

    override fun map(input: List<BendingBuddyResponseItem>?): List<BendingBuddyEntity> {

        return input?.map {
            BendingBuddyEntity(
                name = it.name.orEmpty(),
                imageUrl = it.photoUrl.orEmpty(),
                affiliation = it.affiliation.orEmpty()
            )
        } ?: emptyList()

    }

}