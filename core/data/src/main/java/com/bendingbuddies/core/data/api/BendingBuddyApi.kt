package com.bendingbuddies.core.data.api

import com.bendingbuddies.core.data.dto.BendingBuddyResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface BendingBuddyApi {

    // @GET("characters")
    @GET("characters?perPage=NUMBER&page=NUMBER") // The above approach is better but for now I choose this to show more BendingBuddies.
    suspend fun getAllBendingBuddies(): List<BendingBuddyResponseItem>

    @GET("characters")
    suspend fun getBendingBuddyByName(
        @Query("name") bendingBuddyName: String
    ): List<BendingBuddyResponseItem>

}