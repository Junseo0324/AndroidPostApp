package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Photo
import com.devhjs.androidstudy.domain.repository.PhotoRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetPhotoListUseCaseTest {

    private lateinit var photoRepository: PhotoRepository
    private lateinit var getPhotoListUseCase: GetPhotoListUseCase

    private val fakePhotos = listOf(
        Photo(albumId = 1, id = 1, title = "사진1", url = "https://test.com/1.jpg", thumbnailUrl = "https://test.com/1_thumb.jpg"),
        Photo(albumId = 1, id = 2, title = "사진2", url = "https://test.com/2.jpg", thumbnailUrl = "https://test.com/2_thumb.jpg"),
        Photo(albumId = 1, id = 3, title = "사진3", url = "https://test.com/3.jpg", thumbnailUrl = "https://test.com/3_thumb.jpg"),
    )

    @Before
    fun setUp() {
        photoRepository = mockk()
        getPhotoListUseCase = GetPhotoListUseCase(photoRepository)
    }

    @Test
    fun `사진 목록 조회 성공 시 Result_Success 반환`() = runTest {
        // Given
        coEvery { photoRepository.getPhotosByAlbumId(1) } returns fakePhotos

        // When
        val result = getPhotoListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(fakePhotos, (result as Result.Success).data)
    }

    @Test
    fun `사진 목록 조회 성공 시 반환된 개수가 올바른지 확인`() = runTest {
        // Given
        coEvery { photoRepository.getPhotosByAlbumId(1) } returns fakePhotos

        // When
        val result = getPhotoListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Success)
        assertEquals(3, (result as Result.Success).data.size)
    }

    @Test
    fun `사진이 없는 앨범 조회 시 빈 리스트를 Success로 반환`() = runTest {
        // Given
        coEvery { photoRepository.getPhotosByAlbumId(999) } returns emptyList()

        // When
        val result = getPhotoListUseCase.execute(999)

        // Then
        assertTrue(result is Result.Success)
        assertTrue((result as Result.Success).data.isEmpty())
    }

    @Test
    fun `네트워크 오류 발생 시 Result_Error 반환`() = runTest {
        // Given
        coEvery { photoRepository.getPhotosByAlbumId(1) } throws RuntimeException("네트워크 연결 실패")

        // When
        val result = getPhotoListUseCase.execute(1)

        // Then
        assertTrue(result is Result.Error)
        assertEquals(
            "해당 앨범의 사진을 불러오는데 실패했습니다.",
            (result as Result.Error).error
        )
    }
}
