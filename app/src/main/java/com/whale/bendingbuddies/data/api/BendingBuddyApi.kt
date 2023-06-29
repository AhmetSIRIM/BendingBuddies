package com.whale.bendingbuddies.data.api

import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface BendingBuddyApi {

    @GET("characters")
    suspend fun getAllBendingBuddies(): List<BendingBuddyResponseItem>?

    @GET("characters")
    suspend fun getBendingBuddyByName(
        @Query("name") bendingBuddyName: String
    ): BendingBuddyResponseItem

}