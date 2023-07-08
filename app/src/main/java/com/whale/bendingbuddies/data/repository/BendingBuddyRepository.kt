package com.whale.bendingbuddies.data.repository

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem

interface BendingBuddyRepository {

    suspend fun getAllBendingBuddies(): NetworkResponseState<List<BendingBuddyResponseItem>>
    suspend fun getBendingBuddyByName(bendingBuddyName: String): NetworkResponseState<List<BendingBuddyResponseItem>>

}