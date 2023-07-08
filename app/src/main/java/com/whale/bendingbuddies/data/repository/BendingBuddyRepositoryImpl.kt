package com.whale.bendingbuddies.data.repository

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.data.source.RemoteDataSource
import com.whale.bendingbuddies.di.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BendingBuddyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BendingBuddyRepository {

    override suspend fun getAllBendingBuddies(): NetworkResponseState<List<BendingBuddyResponseItem>> {
        return withContext(ioDispatcher) {
            try {
                remoteDataSource.getAllBendingBuddies()
            } catch (exception: Exception) {
                NetworkResponseState.Error(exception)
            }
        }
    }

    override suspend fun getBendingBuddyByName(bendingBuddyName: String): NetworkResponseState<List<BendingBuddyResponseItem>> {
        return withContext(ioDispatcher) {
            try {
                remoteDataSource.getBendingBuddyByName(bendingBuddyName)
            } catch (exception: Exception) {
                NetworkResponseState.Error(exception)
            }
        }
    }

}