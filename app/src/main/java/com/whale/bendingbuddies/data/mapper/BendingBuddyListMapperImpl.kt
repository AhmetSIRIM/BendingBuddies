package com.whale.bendingbuddies.data.mapper

import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import javax.inject.Inject

class BendingBuddyListMapperImpl @Inject constructor() :
    BendingBuddyListMapper<BendingBuddyResponseItem, BendingBuddyEntity> {

    override fun map(input: List<BendingBuddyResponseItem>?): List<BendingBuddyEntity> {
        return input?.map {
            BendingBuddyEntity(
                name = it.name.orEmpty(),
                photoUrl = it.photoUrl.orEmpty(),
                affiliation = it.affiliation.orEmpty()
            )
        } ?: emptyList()
    }

}