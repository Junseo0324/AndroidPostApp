package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Todo
import com.devhjs.androidstudy.domain.repository.TodoRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetTodoListUseCaseTest {

    private lateinit var todoRepository: TodoRepository
    private lateinit var getTodoListUseCase: GetTodoListUseCase

    private val fakeTodos = listOf(
        Todo(userId = 1, id = 1, title = "할 일1", completed = false),
        Todo(userId = 1, id = 2, title = "할 일2", completed = true),
        Todo(userId = 1, id = 3, title = "할 일3", completed = false),
    )

    @Before
    fun setUp() {
        todoRepository = mockk()
        getTodoListUseCase = GetTodoListUseCase(todoRepository)
    }

    @Test
    fun `할 일 목록 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { todoRepository.getTodosByUserId(1) } returns fakeTodos

        // When
        val result = getTodoListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakeTodos, (result as Result.Success).data)
    }

    @Test
    fun `할 일 목록 조회 성공 시 반환된 개수가 올바른지 확인`() = runTest {
        // Given
        coEvery { todoRepository.getTodosByUserId(1) } returns fakeTodos

        // When
        val result = getTodoListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(3, (result as Result.Success).data.size)
    }

    @Test
    fun `할 일이 없는 유저 조회 시 빈 리스트를 Success로 반환`() = runTest {
        // Given
        coEvery { todoRepository.getTodosByUserId(999) } returns emptyList()

        // When
        val result = getTodoListUseCase.execute(999)

        // Then
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { todoRepository.getTodosByUserId(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getTodoListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals("할 일 목록을 가져오는데 실패했습니다.", (result as Result.Error).error)
    }
}
