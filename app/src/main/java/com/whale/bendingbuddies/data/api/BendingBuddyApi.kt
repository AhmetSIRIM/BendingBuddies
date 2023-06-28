package com.whale.bendingbuddies.data.api

import com.whale.bendingbuddies.data.dto.BendingBuddyResponse
import retrofit2.http.GET

interface BendingBuddyApi {

    @GET("characters")
    suspend fun getAllBendingBuddies(): BendingBuddyResponse

}