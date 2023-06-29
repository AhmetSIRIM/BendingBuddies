package com.whale.bendingbuddies.domain.usecase

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapper
import com.whale.bendingbuddies.data.repository.BendingBuddyRepository
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBendingBuddiesUseCaseImpl @Inject constructor(
    private val bendingBuddyRepository: BendingBuddyRepository,
    private val bendingBuddyListMapper: BendingBuddyListMapper<BendingBuddyResponseItem, BendingBuddyEntity>
) : GetAllBendingBuddiesUseCase {

    override fun invoke(): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {

        return flow {

            emit(NetworkResponseState.Loading)

            when (val response = bendingBuddyRepository.getAllBendingBuddies()) {

                is NetworkResponseState.Error -> emit(response)

                NetworkResponseState.Loading -> Unit

                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(
                        bendingBuddyListMapper.map(response.result)
                    )
                )

            }

        }

    }

}