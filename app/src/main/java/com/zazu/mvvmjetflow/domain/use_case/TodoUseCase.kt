package com.zazu.mvvmjetflow.domain.use_case

import com.zazu.mvvmjetflow.common.ApiResource
import com.zazu.mvvmjetflow.common.result

import com.zazu.mvvmjetflow.data.repository.TodoRepository
import com.zazu.mvvmjetflow.domain.model.TodoResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.HttpException
import javax.inject.Inject

class TodoUseCase @Inject constructor(private val repository: TodoRepository) {
    operator fun invoke(): Flow<ApiResource<TodoResponse?>> = result {
        repository.getTodo()
    }

//    operator fun invoke(): Flow<ApiResource<TodoResponse?>> = flow{
//        try {
//            emit(ApiResource.Loading)
//            val todoList = repository.getTodo().body()
//            emit(ApiResource.Success(todoList))
//        }catch (e: HttpException) {
//            emit(ApiResource.Failure(e.localizedMessage))
//        }
//    }
}