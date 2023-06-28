package com.whale.bendingbuddies.data.dto

import com.google.gson.annotations.SerializedName

data class BendingBuddyResponse(
    @SerializedName("characters")
    val bendingBuddyResponseItem: List<BendingBuddyResponseItem>
)