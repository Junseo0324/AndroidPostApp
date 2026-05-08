package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Album
import com.devhjs.androidstudy.domain.repository.AlbumRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetAlbumListUseCaseTest {

    private lateinit var albumRepository: AlbumRepository
    private lateinit var getAlbumListUseCase: GetAlbumListUseCase

    private val fakeAlbums = listOf(
        Album(userId = 1, id = 1, title = "첫 번째 앨범"),
        Album(userId = 1, id = 2, title = "두 번째 앨범"),
        Album(userId = 1, id = 3, title = "세 번째 앨범"),
    )

    @Before
    fun setUp() {
        albumRepository = mockk()
        getAlbumListUseCase = GetAlbumListUseCase(albumRepository)
    }

    @Test
    fun `앨범 목록 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { albumRepository.getAlbumsByUserId(1) } returns fakeAlbums

        // When
        val result = getAlbumListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakeAlbums, (result as Result.Success).data)
    }

    @Test
    fun `앨범 목록 조회 성공 시 반환된 개수가 올바른지 확인`() = runTest {
        // Given
        coEvery { albumRepository.getAlbumsByUserId(1) } returns fakeAlbums

        // When
        val result = getAlbumListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(3, (result as Result.Success).data.size)
    }

    @Test
    fun `앨범이 없는 유저 조회 시 빈 리스트를 Success로 반환`() = runTest {
        // Given
        coEvery { albumRepository.getAlbumsByUserId(999) } returns emptyList()

        // When
        val result = getAlbumListUseCase.execute(999)

        // Then
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { albumRepository.getAlbumsByUserId(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getAlbumListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals(
            "해당 유저의 앨범을 불러오는데 실패했습니다.",
            (result as Result.Error).error
        )
    }
}