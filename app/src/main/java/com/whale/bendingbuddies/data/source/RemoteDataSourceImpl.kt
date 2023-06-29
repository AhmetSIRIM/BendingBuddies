package com.whale.bendingbuddies.data.source

import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.api.BendingBuddyApi
import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val bendingBuddyApi: BendingBuddyApi
) : RemoteDataSource {

    override suspend fun getAllBendingBuddies(): NetworkResponseState<List<BendingBuddyResponseItem>> {
        return try {
            val response = bendingBuddyApi.getAllBendingBuddies()
            NetworkResponseState.Success(response)
        } catch (exception: Exception) {
            NetworkResponseState.Error(exception)
        }
    }

    override suspend fun getBendingBuddiesByName(bendingBuddyName: String): NetworkResponseState<BendingBuddyResponseItem> {
        return try {
            val response = bendingBuddyApi.getBendingBuddiesByName(bendingBuddyName)
            NetworkResponseState.Success(response)
        } catch (exception: Exception) {
            NetworkResponseState.Error(exception)
        }
    }

}