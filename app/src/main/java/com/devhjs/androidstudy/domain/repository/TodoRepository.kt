package com.devhjs.androidstudy.domain.repository

import com.devhjs.androidstudy.domain.model.Todo

interface TodoRepository {
    suspend fun getTodosByUserId(userId: Int): List<Todo>
}