package com.zazu.mvvmjetflow.presentation.view_model

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zazu.mvvmjetflow.common.ApiResource
import com.zazu.mvvmjetflow.domain.use_case.TodoUseCase
import com.zazu.mvvmjetflow.presentation.todo_list.Todostate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoUseCase: TodoUseCase): ViewModel() {
    private val _state = mutableStateOf(Todostate())
    val state: State<Todostate> = _state

    init {
        getTodo()
    }

    private fun getTodo(){
        todoUseCase().onEach {result->
            when(result){
                is ApiResource.Failure -> _state.value = Todostate(error = result.errorBody.toString())
                ApiResource.Loading -> _state.value = Todostate(isLoading = true)
                is ApiResource.Success-> {

                    _state.value = result.value?.let { Todostate(todoList = it) }!!}
            }

        }.launchIn(viewModelScope)
    }
}