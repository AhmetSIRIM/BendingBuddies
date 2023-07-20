package com.bendingbuddies.core.data.source

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.data.dto.BendingBuddyResponseItem

interface RemoteDataSource {

    suspend fun getAllBendingBuddies(): NetworkResponseState<List<BendingBuddyResponseItem>>
    suspend fun getBendingBuddyByName(bendingBuddyName: String): NetworkResponseState<List<BendingBuddyResponseItem>>

}