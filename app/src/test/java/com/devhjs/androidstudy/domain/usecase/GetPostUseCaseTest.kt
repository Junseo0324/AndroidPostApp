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

class GetPostUseCaseTest {

    private lateinit var postRepository: PostRepository
    private lateinit var getPostUseCase: GetPostUseCase

    private val fakePost = Post(userId = 1, id = 1, title = "테스트 게시글", body = "테스트 내용입니다.")

    @Before
    fun setUp() {
        postRepository = mockk()
        getPostUseCase = GetPostUseCase(postRepository)
    }

    @Test
    fun `게시글 단건 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { postRepository.getPost(1) } returns fakePost

        // When
        val result = getPostUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakePost, (result as Result.Success).data)
    }

    @Test
    fun `게시글 단건 조회 성공 시 데이터 필드가 올바른지 확인`() = runTest {
        // Given
        coEvery { postRepository.getPost(1) } returns fakePost

        // When
        val result = getPostUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        val post = (result as Result.Success).data
        assertEquals(1, post.userId)
        assertEquals(1, post.id)
        assertEquals("테스트 게시글", post.title)
        assertEquals("테스트 내용입니다.", post.body)
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        val exception = RuntimeException("네트워크 연결 실패")
        coEvery { postRepository.getPost(1) } throws exception

        // When
        val result = getPostUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals(exception, (result as Result.Error).error)
    }
}
