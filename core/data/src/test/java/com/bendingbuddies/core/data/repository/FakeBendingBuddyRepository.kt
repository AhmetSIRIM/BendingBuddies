package com.bendingbuddies.core.data.repository

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.data.NetworkResponseStateEnumForTest
import com.bendingbuddies.core.data.mapper.BendingBuddyListMapperImpl
import com.bendingbuddies.core.data.sampleBendingBuddyResponseItem
import com.bendingbuddies.core.data.sampleUnknownErrorException
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import com.bendingbuddies.core.domain.repository.BendingBuddyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class FakeBendingBuddyRepository(
    private val bendingBuddyListMapperImpl: BendingBuddyListMapperImpl
) : BendingBuddyRepository {


    private var networkResponseStateForTest = NetworkResponseStateEnumForTest.LOADING

    fun setNetworkResponseStateForTest(networkResponseStateEnumForTest: NetworkResponseStateEnumForTest) {
        this.networkResponseStateForTest = networkResponseStateEnumForTest
    }

    override fun getAllBendingBuddies(): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {

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
                        bendingBuddyListMapperImpl.map(
                            listOf(
                                sampleBendingBuddyResponseItem
                            )
                        )
                    )
                )

                NetworkResponseStateEnumForTest.LOADING -> emit(NetworkResponseState.Loading)

            }
        }
    }

    override fun getBendingBuddyByName(bendingBuddyName: String): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {

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
                        bendingBuddyListMapperImpl.map(
                            listOf(
                                sampleBendingBuddyResponseItem
                            )
                        )
                    )
                )

                NetworkResponseStateEnumForTest.LOADING -> emit(NetworkResponseState.Loading)

            }
        }
    }

}