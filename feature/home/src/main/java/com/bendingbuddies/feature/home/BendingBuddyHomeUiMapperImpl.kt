package com.bendingbuddies.feature.home

import com.bendingbuddies.core.common.mapper.BendingBuddyListMapper
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import com.bendingbuddies.core.presentation.model.home.HomeUiData
import javax.inject.Inject

class BendingBuddyHomeUiMapperImpl @Inject constructor() :
    BendingBuddyListMapper<BendingBuddyEntity, HomeUiData> {

    override fun map(input: List<BendingBuddyEntity>?): List<HomeUiData> {

        return input?.map {
            HomeUiData(
                name = it.name,
                imageUrl = it.imageUrl
            )
        } ?: emptyList()

    }

}