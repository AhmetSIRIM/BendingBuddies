package com.whale.bendingbuddies.data.mapper

import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.domain.BendingBuddyEntity

class BendingBuddyMapperImpl : BendingBuddyMapper<BendingBuddyResponseItem, BendingBuddyEntity> {

    override fun map(input: BendingBuddyResponseItem?): BendingBuddyEntity {
        return BendingBuddyEntity(
            name = input?.name.orEmpty(),
            photoUrl = input?.photoUrl.orEmpty(),
            affiliation = input?.affiliation.orEmpty()
        )
    }

}