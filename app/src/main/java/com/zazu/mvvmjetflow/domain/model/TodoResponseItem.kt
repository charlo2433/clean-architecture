package com.zazu.mvvmjetflow.domain.model

data class TodoResponseItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)