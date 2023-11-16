package com.zazu.mvvmjetflow.data.remote

import com.zazu.mvvmjetflow.domain.model.TodoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodo(): Response<TodoResponse>
}