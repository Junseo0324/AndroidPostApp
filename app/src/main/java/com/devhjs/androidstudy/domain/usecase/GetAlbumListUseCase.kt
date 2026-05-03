package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.model.Album
import com.devhjs.androidstudy.domain.repository.AlbumRepository
import javax.inject.Inject

class GetAlbumListUseCase @Inject constructor(
    private val albumRepository: AlbumRepository
) {
    suspend fun execute(userId: Int): Result<List<Album>, String> {
        return try {
            val albums = albumRepository.getAlbumsByUserId(userId)
            Result.Success(albums)
        } catch (e: Exception) {
            Result.Error("해당 유저의 앨범을 불러오는데 실패했습니다.")
        }
    }
}