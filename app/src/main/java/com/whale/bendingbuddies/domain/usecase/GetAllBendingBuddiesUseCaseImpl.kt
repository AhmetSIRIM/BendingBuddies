package com.whale.bendingbuddies.domain.usecase

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.domain.entity.BendingBuddyEntity
import com.whale.bendingbuddies.domain.repository.BendingBuddyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllBendingBuddiesUseCaseImpl @Inject constructor(
    private val bendingBuddyRepository: BendingBuddyRepository,
) : GetAllBendingBuddiesUseCase {

    override fun invoke(): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {
        return bendingBuddyRepository.getAllBendingBuddies()
    }

}