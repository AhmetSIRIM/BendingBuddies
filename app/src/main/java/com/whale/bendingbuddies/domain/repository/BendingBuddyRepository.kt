package com.whale.bendingbuddies.domain.repository

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.domain.entity.BendingBuddyEntity
import kotlinx.coroutines.flow.Flow

interface BendingBuddyRepository {

    fun getAllBendingBuddies(): Flow<NetworkResponseState<List<BendingBuddyEntity>>>
    fun getBendingBuddyByName(bendingBuddyName: String): Flow<NetworkResponseState<List<BendingBuddyEntity>>>

}