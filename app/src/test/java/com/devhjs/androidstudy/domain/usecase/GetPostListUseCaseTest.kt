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

class GetPostListUseCaseTest {

    private lateinit var postRepository: PostRepository
    private lateinit var getPostListUseCase: GetPostListUseCase

    private val fakePosts = listOf(
        Post(userId = 1, id = 1, title = "게시글1", body = "내용1"),
        Post(userId = 2, id = 2, title = "게시글2", body = "내용2"),
        Post(userId = 3, id = 3, title = "게시글3", body = "내용3"),
    )

    @Before
    fun setUp() {
        postRepository = mockk()
        getPostListUseCase = GetPostListUseCase(postRepository)
    }

    @Test
    fun `전체 게시글 목록 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { postRepository.getPosts() } returns fakePosts

        // When
        val result = getPostListUseCase.execute()

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakePosts, (result as Result.Success).data)
    }

    @Test
    fun `전체 게시글 목록 조회 성공 시 반환된 개수가 올바른지 확인`() = runTest {
        // Given
        coEvery { postRepository.getPosts() } returns fakePosts

        // When
        val result = getPostListUseCase.execute()

        // Then
        assertTrue(result is Result.Success)
        assertEquals(3, (result as Result.Success).data.size)
    }

    @Test
    fun `게시글이 없을 때 빈 리스트를 Success로 반환`() = runTest {
        // Given
        coEvery { postRepository.getPosts() } returns emptyList()

        // When
        val result = getPostListUseCase.execute()

        // Then
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        val exception = RuntimeException("네트워크 연결 실패")
        coEvery { postRepository.getPosts() } throws exception

        // When
        val result = getPostListUseCase.execute()

        // Then
        assertTrue(result is Result.Error)
        assertEquals(exception, (result as Result.Error).error)
    }
}
