package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.repository.AlbumRepository
import com.devhjs.androidstudy.domain.repository.PostRepository
import javax.inject.Inject

class GetPostAndAlbumUseCase @Inject constructor(
    private val postRepository: PostRepository,
    private val albumRepository: AlbumRepository
) {
    suspend fun execute(userId: Int): Result<Pair<Int, Int>, String> {
        return try {
            val postCount = postRepository.getPostsByUserId(userId).size
            val albumCount = albumRepository.getAlbumsByUserId(userId).size
            Result.Success(Pair(postCount, albumCount))
        } catch (e: Exception) {
            Result.Error("데이터를 가져오는 데 실패했습니다.")
        }
    }
}