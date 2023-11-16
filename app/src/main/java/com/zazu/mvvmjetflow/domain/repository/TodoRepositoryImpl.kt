package com.zazu.mvvmjetflow.domain.repository

import com.zazu.mvvmjetflow.data.remote.ApiService
import com.zazu.mvvmjetflow.data.repository.TodoRepository
import com.zazu.mvvmjetflow.domain.model.TodoResponse
import retrofit2.Response
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val api: ApiService):TodoRepository {
    override suspend fun getTodo(): Response<TodoResponse> {
       return api.getTodo()
    }
}