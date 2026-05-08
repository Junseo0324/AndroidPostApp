package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Album
import com.devhjs.androidstudy.domain.model.Post
import com.devhjs.androidstudy.domain.model.Todo
import com.devhjs.androidstudy.domain.repository.AlbumRepository
import com.devhjs.androidstudy.domain.repository.PostRepository
import com.devhjs.androidstudy.domain.repository.TodoRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetPostAndAlbumUseCaseTest {

    private lateinit var postRepository: PostRepository
    private lateinit var albumRepository: AlbumRepository
    private lateinit var todoRepository: TodoRepository
    private lateinit var getPostAndAlbumUseCase: GetPostAndAlbumUseCase

    private val fakePosts = listOf(
        Post(userId = 1, id = 1, title = "게시글1", body = "내용1"),
        Post(userId = 1, id = 2, title = "게시글2", body = "내용2"),
    )

    private val fakeAlbums = listOf(
        Album(userId = 1, id = 1, title = "앨범1"),
        Album(userId = 1, id = 2, title = "앨범2"),
        Album(userId = 1, id = 3, title = "앨범3"),
    )

    private val fakeTodos = listOf(
        Todo(userId = 1, id = 1, title = "할 일1", completed = false),
    )

    @Before
    fun setUp() {
        postRepository = mockk()
        albumRepository = mockk()
        todoRepository = mockk()
        getPostAndAlbumUseCase = GetPostAndAlbumUseCase(postRepository, albumRepository, todoRepository)
    }

    @Test
    fun `게시글, 앨범, 할 일 개수 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(1) } returns fakePosts
        coEvery { albumRepository.getAlbumsByUserId(1) } returns fakeAlbums
        coEvery { todoRepository.getTodosByUserId(1) } returns fakeTodos

        // When
        val result = getPostAndAlbumUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        val triple = (result as Result.Success).data
        assertEquals(2, triple.first)
        assertEquals(3, triple.second)
        assertEquals(1, triple.third)
    }

    @Test
    fun `데이터가 없는 유저 조회 시 모두 0을 반환`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(999) } returns emptyList()
        coEvery { albumRepository.getAlbumsByUserId(999) } returns emptyList()
        coEvery { todoRepository.getTodosByUserId(999) } returns emptyList()

        // When
        val result = getPostAndAlbumUseCase.execute(999)

        // Then
        assertTrue(result is Result.Success)
        val triple = (result as Result.Success).data
        assertEquals(0, triple.first)
        assertEquals(0, triple.second)
        assertEquals(0, triple.third)
    }

    @Test
    fun `PostRepository에서 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getPostAndAlbumUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals(
            "데이터를 가져오는 데 실패했습니다.",
            (result as Result.Error).error
        )
    }

    @Test
    fun `AlbumRepository에서 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { postRepository.getPostsByUserId(1) } returns fakePosts
        coEvery { albumRepository.getAlbumsByUserId(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getPostAndAlbumUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals(
            "데이터를 가져오는 데 실패했습니다.",
            (result as Result.Error).error
        )
    }
}
