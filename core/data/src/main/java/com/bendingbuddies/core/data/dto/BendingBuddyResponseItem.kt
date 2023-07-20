package com.bendingbuddies.core.data.dto

import com.google.gson.annotations.SerializedName

data class BendingBuddyResponseItem(
    @SerializedName("affiliation")
    val affiliation: String?,
    @SerializedName("allies")
    val allies: List<String?>?,
    @SerializedName("enemies")
    val enemies: List<String?>?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("photoUrl")
    val photoUrl: String?
)