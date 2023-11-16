package com.zazu.mvvmjetflow.presentation.todo_list

import com.zazu.mvvmjetflow.domain.model.TodoResponseItem

data class Todostate(
    val isLoading: Boolean = false,
    val todoList: List<TodoResponseItem> = emptyList(),
    val error: String = ""
)
