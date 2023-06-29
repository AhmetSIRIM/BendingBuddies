package com.whale.bendingbuddies.data

import java.lang.Exception

sealed class NetworkResponseState<out T : Any> {
    object Loading : NetworkResponseState<Nothing>()
    data class Error(val exception: Exception) : NetworkResponseState<Nothing>()
    data class Success<out T : Any>(val result: T?) : NetworkResponseState<T>()
}