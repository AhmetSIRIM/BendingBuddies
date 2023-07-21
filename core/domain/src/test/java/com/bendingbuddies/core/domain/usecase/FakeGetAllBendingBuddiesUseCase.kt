package com.bendingbuddies.core.domain.usecase

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.NetworkResponseStateEnumForTest
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import com.bendingbuddies.core.domain.sampleBendingBuddyEntity
import com.bendingbuddies.core.domain.sampleUnknownErrorException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetAllBendingBuddiesUseCase : GetAllBendingBuddiesUseCase {

    private var networkResponseStateForTest = NetworkResponseStateEnumForTest.LOADING

    fun setNetworkResponseStateForTest(networkResponseStateEnumForTest: NetworkResponseStateEnumForTest) {
        this.networkResponseStateForTest = networkResponseStateEnumForTest
    }

    override fun invoke(): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {

        return flow {

            emit(NetworkResponseState.Loading)

            when (networkResponseStateForTest) {

                NetworkResponseStateEnumForTest.ERROR -> emit(
                    NetworkResponseState.Error(
                        sampleUnknownErrorException
                    )
                )

                NetworkResponseStateEnumForTest.SUCCESS -> emit(
                    NetworkResponseState.Success(
                        listOf(sampleBendingBuddyEntity)
                    )
                )

                NetworkResponseStateEnumForTest.LOADING -> emit(NetworkResponseState.Loading)

            }

        }

    }

}