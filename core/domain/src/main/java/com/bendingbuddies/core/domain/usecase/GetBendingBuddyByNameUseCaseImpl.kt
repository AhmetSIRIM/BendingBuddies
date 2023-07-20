package com.bendingbuddies.core.domain.usecase

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import com.bendingbuddies.core.domain.repository.BendingBuddyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBendingBuddyByNameUseCaseImpl @Inject constructor(
    private val bendingBuddyRepository: BendingBuddyRepository,
) : GetBendingBuddyByNameUseCase {

    override fun invoke(bendingBuddyName: String): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {
        return bendingBuddyRepository.getBendingBuddyByName(bendingBuddyName)
    }

}