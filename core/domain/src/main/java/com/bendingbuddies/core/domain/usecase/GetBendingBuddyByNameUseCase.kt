package com.bendingbuddies.core.domain.usecase

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import kotlinx.coroutines.flow.Flow

interface GetBendingBuddyByNameUseCase {

    operator fun invoke(bendingBuddyName: String): Flow<NetworkResponseState<List<BendingBuddyEntity>>>

}