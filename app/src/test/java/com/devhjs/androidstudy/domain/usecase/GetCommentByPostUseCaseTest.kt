package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Comment
import com.devhjs.androidstudy.domain.repository.CommentRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetCommentByPostUseCaseTest {

    private lateinit var commentRepository: CommentRepository
    private lateinit var getCommentByPostUseCase: GetCommentByPostUseCase

    private val fakeComments = listOf(
        Comment(postId = 1, id = 1, name = "댓글 작성자1", email = "user1@test.com", body = "첫 번째 댓글"),
        Comment(postId = 1, id = 2, name = "댓글 작성자2", email = "user2@test.com", body = "두 번째 댓글"),
    )

    @Before
    fun setUp() {
        commentRepository = mockk()
        getCommentByPostUseCase = GetCommentByPostUseCase(commentRepository)
    }

    @Test
    fun `댓글 목록 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { commentRepository.getCommentsByPostId(1) } returns fakeComments

        // When
        val result = getCommentByPostUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakeComments, (result as Result.Success).data)
    }

    @Test
    fun `댓글 목록 조회 성공 시 반환된 개수가 올바른지 확인`() = runTest {
        // Given
        coEvery { commentRepository.getCommentsByPostId(1) } returns fakeComments

        // When
        val result = getCommentByPostUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(2, (result as Result.Success).data.size)
    }

    @Test
    fun `댓글이 없는 게시글 조회 시 빈 리스트를 Success로 반환`() = runTest {
        // Given
        coEvery { commentRepository.getCommentsByPostId(999) } returns emptyList()

        // When
        val result = getCommentByPostUseCase.execute(999)

        // Then
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { commentRepository.getCommentsByPostId(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getCommentByPostUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals(
            "에러가 발생했습니다.",
            (result as Result.Error).error
        )
    }
}
