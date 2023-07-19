package com.whale.bendingbuddies.data.repository

import com.whale.bendingbuddies.NetworkResponseStateEnumForTest
import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapperImpl
import com.whale.bendingbuddies.domain.entity.BendingBuddyEntity
import com.whale.bendingbuddies.domain.repository.BendingBuddyRepository
import com.whale.bendingbuddies.sampleBendingBuddyResponseItem
import com.whale.bendingbuddies.sampleUnknownErrorException
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