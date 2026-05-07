package com.devhjs.androidstudy.domain.usecase

import com.devhjs.androidstudy.core.util.Result
import com.devhjs.androidstudy.domain.repository.AlbumRepository
import com.devhjs.androidstudy.domain.repository.PostRepository
import com.devhjs.androidstudy.domain.repository.TodoRepository
import javax.inject.Inject

class GetPostAndAlbumUseCase @Inject constructor(
    private val postRepository: PostRepository,
    private val albumRepository: AlbumRepository,
    private val todoRepository: TodoRepository,
) {
    suspend fun execute(userId: Int): Result<Triple<Int, Int, Int>, String> {
        return try {
            val postCount = postRepository.getPostsByUserId(userId).size
            val albumCount = albumRepository.getAlbumsByUserId(userId).size
            val todoCount = todoRepository.getTodosByUserId(userId).size
            Result.Success(Triple(postCount, albumCount,todoCount))
        } catch (e: Exception) {
            Result.Error("데이터를 가져오는 데 실패했습니다.")
        }
    }
}