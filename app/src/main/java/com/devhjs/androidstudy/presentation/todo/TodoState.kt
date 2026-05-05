package com.devhjs.androidstudy.presentation.todo

import androidx.compose.runtime.Immutable
import com.devhjs.androidstudy.domain.model.Todo

@Immutable
data class TodoState(
    val isLoading: Boolean = false,
    val todos: List<Todo> = emptyList(),
    val error: String? = null
)
