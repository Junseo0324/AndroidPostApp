package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.TodoDto
import com.devhjs.androidstudy.domain.model.Todo

fun Todo.toDto(): TodoDto {
    return TodoDto(
        userId = this.userId,
        id = this.id,
        title = this.title,
        completed = this.completed
    )
}

fun TodoDto.toModel(): Todo {
    return Todo(
        userId = this.userId ?: 0,
        id = this.id ?: 0,
        title = this.title ?: "",
        completed = this.completed ?: false
    )
}