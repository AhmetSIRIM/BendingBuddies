package com.bendingbuddies.core.domain.usecase

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import kotlinx.coroutines.flow.Flow

interface GetAllBendingBuddiesUseCase {

    operator fun invoke(): Flow<NetworkResponseState<List<BendingBuddyEntity>>>

}