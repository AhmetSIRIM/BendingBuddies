package com.whale.bendingbuddies.data.source

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem

interface RemoteDataSource {

    suspend fun getAllBendingBuddies(): NetworkResponseState<List<BendingBuddyResponseItem>>
    suspend fun getBendingBuddyByName(bendingBuddyName: String): NetworkResponseState<BendingBuddyResponseItem>

}