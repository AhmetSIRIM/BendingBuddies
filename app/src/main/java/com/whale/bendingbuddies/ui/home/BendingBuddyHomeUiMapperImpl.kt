package com.whale.bendingbuddies.ui.home

import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapper
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import javax.inject.Inject

class BendingBuddyHomeUiMapperImpl @Inject constructor() :
    BendingBuddyListMapper<BendingBuddyEntity, HomeUiData> {

    override fun map(input: List<BendingBuddyEntity>?): List<HomeUiData> {

        return input?.map {
            HomeUiData(
                name = it.name,
                imageUrl = it.photoUrl
            )
        } ?: emptyList()

    }

}