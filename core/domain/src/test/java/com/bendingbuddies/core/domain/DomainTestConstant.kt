package com.bendingbuddies.core.domain

import androidx.annotation.VisibleForTesting
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity

const val KORRA_PARAMETER = "Korra"

@VisibleForTesting
val sampleBendingBuddyEntity = BendingBuddyEntity(
    KORRA_PARAMETER,
    "https://vignette.wikia.nocookie.net/avatar/images/c/ca/Korra.png/revision/latest?cb=20150406235047",
    " Fire Ferrets (formerly) Southern Water Tribe Tarrlok's task force (formerly) Team Avatar"
)

enum class NetworkResponseStateEnumForTest {
    ERROR,
    SUCCESS,
    LOADING
}

@VisibleForTesting
val sampleUnknownErrorException = Exception("An unknown error occurred")