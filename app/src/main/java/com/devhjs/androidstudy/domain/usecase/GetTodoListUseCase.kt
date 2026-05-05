package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Todo
import com.devhjs.androidstudy.domain.repository.TodoRepository
import javax.inject.Inject

class GetTodoListUseCase @Inject constructor(
    private val todoRepository: TodoRepository,
) {
    suspend fun execute(userId: Int): Result<List<Todo>, String> {
        return try {
            val todos = todoRepository.getTodosByUserId(userId)
            Result.Success(todos)
        } catch (e: Exception) {
            Result.Error("할 일 목록을 가져오는데 실패했습니다.")
        }
    }
}