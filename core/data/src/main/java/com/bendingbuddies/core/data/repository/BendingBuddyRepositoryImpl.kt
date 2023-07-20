package com.bendingbuddies.core.data.repository

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.data.di.coroutine.IoDispatcher
import com.bendingbuddies.core.data.dto.BendingBuddyResponseItem
import com.bendingbuddies.core.common.mapper.BendingBuddyListMapper
import com.bendingbuddies.core.data.source.RemoteDataSource
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import com.bendingbuddies.core.domain.repository.BendingBuddyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BendingBuddyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val bendingBuddyListMapper: BendingBuddyListMapper<BendingBuddyResponseItem, BendingBuddyEntity>,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BendingBuddyRepository {

    override fun getAllBendingBuddies(): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {

        return flow {

            emit(NetworkResponseState.Loading)

            when (val response = remoteDataSource.getAllBendingBuddies()) {

                is NetworkResponseState.Error -> {
                    emit(NetworkResponseState.Error(response.exception))
                }

                NetworkResponseState.Loading -> Unit

                is NetworkResponseState.Success -> {
                    emit(
                        NetworkResponseState.Success(
                            bendingBuddyListMapper.map(response.result)
                        )
                    )
                }

            }

        }.flowOn(ioDispatcher)

    }

    override fun getBendingBuddyByName(bendingBuddyName: String): Flow<NetworkResponseState<List<BendingBuddyEntity>>> {

        return flow {

            emit(NetworkResponseState.Loading)

            when (val response = remoteDataSource.getBendingBuddyByName(bendingBuddyName)) {

                is NetworkResponseState.Error -> {
                    emit(NetworkResponseState.Error(response.exception))
                }

                NetworkResponseState.Loading -> Unit

                is NetworkResponseState.Success -> {
                    emit(
                        NetworkResponseState.Success(
                            bendingBuddyListMapper.map(response.result)
                        )
                    )
                }

            }

        }.flowOn(ioDispatcher)

    }

}