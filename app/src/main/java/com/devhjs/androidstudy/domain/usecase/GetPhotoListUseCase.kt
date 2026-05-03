package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Photo
import com.devhjs.androidstudy.domain.repository.PhotoRepository
import javax.inject.Inject

class GetPhotoListUseCase @Inject constructor(
    private val photoRepository: PhotoRepository
) {
    suspend fun execute(albumId: Int): Result<List<Photo>, String> {
        return try {
            val photos = photoRepository.getPhotosByAlbumId(albumId = albumId)
            Result.Success(photos)
        } catch (e: Exception) {
            Result.Error("해당 앨범의 사진을 불러오는데 실패했습니다.")
        }
    }
}