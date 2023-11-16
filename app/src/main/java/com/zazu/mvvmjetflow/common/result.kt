package com.zazu.mvvmjetflow.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

//
 fun <T> result(call: suspend () -> Response<T>): Flow<ApiResource<T?>> = flow {
    emit(ApiResource.Loading)
    try {
        val response = call()
        response.let {
            if (response.isSuccessful) {
                emit(ApiResource.Success(it.body()))
            } else {
                response.errorBody()?.let { error ->
                    error.close()
                    emit(ApiResource.Failure(error.toString()))
                }
            }
        }
    } catch (t: Throwable) {
        t.printStackTrace()
        emit(ApiResource.Failure(t.localizedMessage?.toString()))
    }
}.flowOn(Dispatchers.IO)


