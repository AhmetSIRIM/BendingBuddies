package com.whale.bendingbuddies.domain.usecase

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import kotlinx.coroutines.flow.Flow

interface GetBendingBuddyByNameUseCase {

    operator fun invoke(bendingBuddyName: String): Flow<NetworkResponseState<BendingBuddyEntity>>

}