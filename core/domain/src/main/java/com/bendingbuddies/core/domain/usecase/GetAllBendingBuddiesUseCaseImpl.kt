package com.bendingbuddies.core.domain.usecase

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import com.bendingbuddies.core.domain.repository.BendingBuddyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllBendingBuddiesUseCaseImpl @Inject constructor(
    private val bendingBuddyRepository: BendingBuddyRepository,
) : GetAllBendingBuddiesUseCase {

    override fun invoke(): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {
        return bendingBuddyRepository.getAllBendingBuddies()
    }

}