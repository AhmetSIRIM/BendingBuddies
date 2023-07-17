package com.whale.bendingbuddies.domain.usecase

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.domain.entity.BendingBuddyEntity
import kotlinx.coroutines.flow.Flow

interface GetAllBendingBuddiesUseCase {

    operator fun invoke(): Flow<NetworkResponseState<List<BendingBuddyEntity>>>

}