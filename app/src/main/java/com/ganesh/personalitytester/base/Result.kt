package com.ganesh.personalitytester.base

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T?) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    data class EmptyData(val exception: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()
}
