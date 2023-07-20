package com.bendingbuddies.core.presentation.model.detail

import androidx.annotation.StringRes

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(
        val detailUiData: DetailUiData
    ) : DetailUiState()

    data class Error(
        @StringRes
        val message: Int
    ) : DetailUiState()
}