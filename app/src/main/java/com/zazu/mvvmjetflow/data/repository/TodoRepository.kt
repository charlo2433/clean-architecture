package com.zazu.mvvmjetflow.data.repository

import com.zazu.mvvmjetflow.domain.model.TodoResponse
import retrofit2.Response

interface TodoRepository {
    suspend fun getTodo(): Response<TodoResponse>
}