package com.whale.bendingbuddies.data.repository

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapper
import com.whale.bendingbuddies.data.source.RemoteDataSource
import com.whale.bendingbuddies.di.coroutine.IoDispatcher
import com.whale.bendingbuddies.domain.entity.BendingBuddyEntity
import com.whale.bendingbuddies.domain.repository.BendingBuddyRepository
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