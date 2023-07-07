package com.whale.bendingbuddies.data.mapper

import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import javax.inject.Inject

class BendingBuddyMapperImpl @Inject constructor() :
    BendingBuddyMapper<BendingBuddyResponseItem, BendingBuddyEntity> {

    override fun map(input: BendingBuddyResponseItem?): BendingBuddyEntity {
        return BendingBuddyEntity(
            name = input?.name.orEmpty(),
            imageUrl = input?.photoUrl.orEmpty(),
            affiliation = input?.affiliation.orEmpty()
        )
    }

}