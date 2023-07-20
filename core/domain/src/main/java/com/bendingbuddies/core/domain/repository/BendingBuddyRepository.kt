package com.bendingbuddies.core.domain.repository

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import kotlinx.coroutines.flow.Flow

interface BendingBuddyRepository {

    fun getAllBendingBuddies(): Flow<NetworkResponseState<List<BendingBuddyEntity>>>
    fun getBendingBuddyByName(bendingBuddyName: String): Flow<NetworkResponseState<List<BendingBuddyEntity>>>

}