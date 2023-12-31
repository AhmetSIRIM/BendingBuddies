package com.bendingbuddies.core.data

import com.bendingbuddies.core.data.dto.BendingBuddyResponseItem
import com.google.common.annotations.VisibleForTesting

const val SAMPLE_RESPONSE_FILE_NAME_FOR_GET_ALL_BENDING_BUDDIES = "BendingBuddyResponse.JSON"
const val GET_ALL_BENDING_BUDDIES_PATH = "/characters?perPage=NUMBER&page=NUMBER"

const val SAMPLE_RESPONSE_FILE_NAME_FOR_GET_BENDING_BUDDY_BY_NAME_WITH_KORRA_INPUT =
    "BendingBuddyResponseReturnByKorraParameter.JSON"
const val GET_BENDING_BUDDY_BY_NAME_PATH_WITH_KORRA_INPUT = "/characters?name=Korra"
const val KORRA_PARAMETER = "Korra"

@VisibleForTesting
val sampleBendingBuddyResponseItem = BendingBuddyResponseItem(
    null,
    null,
    null,
    null,
    KORRA_PARAMETER,
    null,
)

enum class NetworkResponseStateEnumForTest {
    ERROR,
    SUCCESS,
    LOADING
}

@VisibleForTesting
val sampleUnknownErrorException = Exception("An unknown error occurred")
