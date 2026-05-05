package com.devhjs.androidstudy.data.repository

import com.devhjs.androidstudy.data.mapper.toModel
import com.devhjs.androidstudy.data.remote.api.TodoApi
import com.devhjs.androidstudy.domain.model.Todo
import com.devhjs.androidstudy.domain.repository.TodoRepository
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val api: TodoApi
) : TodoRepository {
    override suspend fun getTodosByUserId(userId: Int): List<Todo> {
        return api.getTodo(userId).map { it.toModel() }
    }
}