package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.repository.PostRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetPostByUserUseCaseTest {

    private lateinit var postRepository: PostRepository
    private lateinit var getPostByUserUseCase: GetPostByUserUseCase

    private val fakePosts = listOf(
        Post(userId = 1, id = 1, title = "게시글1", body = "내용1"),
        Post(userId = 1, id = 2, title = "게시글2", body = "내용2"),
        Post(userId = 1, id = 3, title = "게시글3", body = "내용3"),
    )

    @Before
    fun setUp() {
        postRepository = mockk()
        getPostByUserUseCase = GetPostByUserUseCase(postRepository)
    }

    @Test
    fun `유저별 게시글 목록 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(1) } returns fakePosts

        // When
        val result = getPostByUserUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakePosts, (result as Result.Success).data)
    }

    @Test
    fun `유저별 게시글 목록 조회 성공 시 반환된 개수가 올바른지 확인`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(1) } returns fakePosts

        // When
        val result = getPostByUserUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(3, (result as Result.Success).data.size)
    }

    @Test
    fun `게시글이 없는 유저 조회 시 빈 리스트를 Success로 반환`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(999) } returns emptyList()

        // When
        val result = getPostByUserUseCase.execute(999)

        // Then
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getPostByUserUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals(
            "해당 유저의 post를 가져오지 못했습니다.",
            (result as Result.Error).error
        )
    }
}
