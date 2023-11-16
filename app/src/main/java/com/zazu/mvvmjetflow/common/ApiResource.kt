package com.zazu.mvvmjetflow.common

sealed class ApiResource<out T>() {
    data class Success<out T>(val value: T) : ApiResource<T>()
    data class Failure(val errorBody: String? ,) : ApiResource<Nothing>()
    object Loading : ApiResource<Nothing>()
}
